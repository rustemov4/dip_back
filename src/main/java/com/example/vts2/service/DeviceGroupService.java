package com.example.vts2.service;

import com.example.vts2.entity.DeviceGroup;
import com.example.vts2.repository.DeviceGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeviceGroupService {
    private final DeviceGroupRepository deviceGroupRepository;
    public List<DeviceGroup> getAllDeviceGroup() {
        return deviceGroupRepository.findAll();
    }
}
