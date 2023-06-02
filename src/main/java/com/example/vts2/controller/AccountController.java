package com.example.vts2.controller;

import com.example.vts2.entity.Account;
import com.example.vts2.entity.Device;
import com.example.vts2.request.AccountRequest;
import com.example.vts2.request.AssignCarRequest;
import com.example.vts2.service.AccountService;
import com.example.vts2.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class AccountController {
    private final AccountService accountService;
    private final DeviceService deviceService;

    @PostMapping("/register")
    public ResponseEntity<?> addAccount(@RequestBody AccountRequest accountRequest) {
        Account account = accountService.addAccount(accountRequest);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Account exists");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Added account");
    }

    @GetMapping("/accounts")
    public ResponseEntity<?> getAllAccounts() {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAllAccounts());
    }

    @PostMapping("/assignCar")
    public ResponseEntity<?> assignCar(@RequestBody AssignCarRequest assignCarRequest) {
        String accountID = assignCarRequest.getAccountID();
        List<String> assignCars = assignCarRequest.getCars();
        boolean assigned = false;
        for (String assignCar : assignCars) {
            Device curDevice = deviceService.getDevicesByDeviceID(assignCar).get(0);
            if (deviceService.existsByAccountIDAndDeviceID(accountID, curDevice.getDeviceID())) {
                System.out.println(accountID + " with " + curDevice.getDeviceID() + " exists");
                continue;
            }
            Device new_device = new Device();
            new_device.setDeviceID(curDevice.getDeviceID());
            new_device.setAccountID(accountID);
            new_device.setVehicleMake(curDevice.getVehicleMake());
            new_device.setVehicleModel(curDevice.getVehicleModel());
            new_device.setSimPhoneNumber(curDevice.getSimPhoneNumber());
            new_device.setEquipmentType(curDevice.getEquipmentType());
            new_device.setLastvalidlatitude(curDevice.getLastvalidlatitude());
            new_device.setLastvalidlongitude(curDevice.getLastvalidlongitude());
            new_device.setLastOdometerKM(curDevice.getLastOdometerKM());
            new_device.setAddress(curDevice.getAddress());
            new_device.setLastGPSTimestamp(curDevice.getLastGPSTimestamp());
            new_device.setGroupID(curDevice.getGroupID());
            deviceService.update(new_device);
            assigned = true;
        }
        if (assigned) return ResponseEntity.status(HttpStatus.OK).body("Assigned");
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Account with such cars exists");
    }
}
