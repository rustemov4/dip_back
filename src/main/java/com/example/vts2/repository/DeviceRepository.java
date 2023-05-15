package com.example.vts2.repository;

import com.example.vts2.entity.Device;
import com.example.vts2.entity.DeviceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, DeviceId> {
    Device findDeviceByDeviceID(String deviceID);
}
