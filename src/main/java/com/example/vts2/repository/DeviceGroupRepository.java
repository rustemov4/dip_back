package com.example.vts2.repository;

import com.example.vts2.entity.DeviceGroup;
import com.example.vts2.entity.DeviceGroupId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceGroupRepository extends JpaRepository<DeviceGroup, DeviceGroupId> {
}
