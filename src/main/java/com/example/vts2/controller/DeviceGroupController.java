package com.example.vts2.controller;

import com.example.vts2.service.DeviceGroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class DeviceGroupController {
    private final DeviceGroupService deviceGroupService;
    @GetMapping("/deviceGroups")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(deviceGroupService.getAllDeviceGroup());
    }
}
