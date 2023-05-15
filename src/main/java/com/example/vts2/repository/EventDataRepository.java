package com.example.vts2.repository;

import com.example.vts2.entity.EventData;
import com.example.vts2.entity.EventDataId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDataRepository extends JpaRepository<EventData, EventDataId> {
    List<EventData> findEventDataByAccountIDAndDeviceIDAndTimestampBetweenOrderByTimestampAsc(String accountID, String deviceID, int timestamp, int timestamp2);

    EventData findTopByAccountIDAndDeviceIDOrderByTimestampDesc(String accountID, String deviceID);

}
