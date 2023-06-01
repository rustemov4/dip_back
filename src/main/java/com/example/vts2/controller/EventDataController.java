package com.example.vts2.controller;


import com.example.vts2.service.EventDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class EventDataController {
    @Autowired
    EventDataService eventDataService;

    @GetMapping("/eventData")
    public ResponseEntity<?> findEventData(@RequestParam(name = "deviceID") String deviceID, @RequestParam(name = "startTimestamp") int startTimestamp, @RequestParam(name = "endTimestamp") int endTimestamp, @RequestParam(name = "accountID") String accountID) {
        return ResponseEntity.status(HttpStatus.OK).body(eventDataService.findEventDataBetween(deviceID, startTimestamp, endTimestamp, accountID));
    }

    @GetMapping("/latestPosition")
    public ResponseEntity<?> findLatestPositionOfDevice(@RequestParam(name = "deviceID") String deviceID, @RequestParam(name = "accountID") String accountID) {
        return ResponseEntity.status(HttpStatus.OK).body(eventDataService.findLatestPositionOfDevice(deviceID));
    }
}
