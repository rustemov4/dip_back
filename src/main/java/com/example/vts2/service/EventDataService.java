package com.example.vts2.service;

import com.example.vts2.entity.EventData;
import com.example.vts2.repository.EventDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
@AllArgsConstructor
public class EventDataService {
    EventDataRepository eventDataRepository;

    public List<EventData> findEventDataBetween(String deviceID, int startTimestamp, int endTimestamp, String accountID) {
        System.out.println(startTimestamp);
        System.out.println(endTimestamp);
        List<EventData> eventDataList = eventDataRepository.findEventDataByAccountIDAndDeviceIDAndTimestampBetweenOrderByTimestampAsc(accountID, deviceID, startTimestamp, endTimestamp);
        System.out.println(eventDataList.size());
        return eventDataList;
    }

    public EventData findLatestPositionOfDevice(String deviceID) {
        return eventDataRepository.findTopByAccountIDAndDeviceIDOrderByTimestampDesc("logitex", deviceID);
    }
}
