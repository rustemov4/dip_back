package com.example.vts2.repository;

import com.example.vts2.entity.Device;
import com.example.vts2.entity.DeviceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, DeviceId> {
    Device findDeviceByDeviceID(String deviceID);
    List<Device> findDevicesByDeviceID(String deviceID);
    List<Device> findDevicesByAccountID(String accountID);
    Device findDeviceByAccountIDAndDeviceID(String accountID, String deviceID);
    List<Device> findDevicesByGroupID(String groupID);
    boolean existsByAccountIDAndDeviceID(String accountID, String deviceID);
}
