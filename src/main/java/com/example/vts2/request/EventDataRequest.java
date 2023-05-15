package com.example.vts2.request;

import lombok.Data;

@Data
public class EventDataRequest {
    String deviceID;
    Long startTimestamp;
    Long endTimestamp;
}
