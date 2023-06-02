package com.example.vts2.service;

import com.example.vts2.entity.Device;
import com.example.vts2.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeviceService {
    DeviceRepository deviceRepository;

    public List<Device> getAllDevice(String accountID) {
        return deviceRepository.findDevicesByAccountID(accountID);
    }

    public Device getDeviceById(String deviceID) {
        return deviceRepository.findDeviceByDeviceID(deviceID);
    }

    public List<Device> getDevicesByDeviceID(String deviceID) {
        return deviceRepository.findDevicesByDeviceID(deviceID);
    }

    public Device getDeviceByAccountAndDeviceID(String accountID, String deviceID) {
        return deviceRepository.findDeviceByAccountIDAndDeviceID(accountID, deviceID);
    }

    public List<Device> getDevicesByGroupId(String groupID) {
        return deviceRepository.findDevicesByGroupID(groupID);
    }

    public boolean existsByAccountIDAndDeviceID(String accountID, String deviceID) {
        return deviceRepository.existsByAccountIDAndDeviceID(accountID, deviceID);
    }

    public void update(Device device) {
        deviceRepository.save(device);
    }
}
