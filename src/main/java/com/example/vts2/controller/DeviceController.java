package com.example.vts2.controller;

import com.example.vts2.entity.Device;
import com.example.vts2.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class DeviceController {
    DeviceService deviceService;
    @GetMapping("/devices")
    public ResponseEntity<?> getAll() {
        List<Device> devices = deviceService.getAllDevice();
        return ResponseEntity.status(HttpStatus.OK).body(devices);
    }
    @GetMapping("/device")
    public ResponseEntity<?> getDeviceById(@RequestParam(name = "deviceID") String deviceID) {
        Device device = deviceService.getDeviceById(deviceID);
        return ResponseEntity.status(HttpStatus.OK).body(device);
    }
}
