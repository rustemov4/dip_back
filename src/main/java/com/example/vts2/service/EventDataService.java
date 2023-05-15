package com.example.vts2.service;

import com.example.vts2.entity.EventData;
import com.example.vts2.repository.EventDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EventDataService {
    EventDataRepository eventDataRepository;

    public List<EventData> findEventDataBetween(String deviceID, int startTimestamp, int endTimestamp) {
        System.out.println(startTimestamp);
        System.out.println(endTimestamp);
        List<EventData> eventDataList = eventDataRepository.findEventDataByAccountIDAndDeviceIDAndTimestampBetweenOrderByTimestampAsc("logitex", deviceID, startTimestamp, endTimestamp);
        System.out.println(eventDataList.size());
        return eventDataList;
    }

    public EventData findLatestPositionOfDevice(String deviceID) {
        return eventDataRepository.findTopByAccountIDAndDeviceIDOrderByTimestampDesc("logitex", deviceID);
    }
}
