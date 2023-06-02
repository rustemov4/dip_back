package com.example.vts2.request;

import lombok.Data;

import java.util.List;

@Data
public class AssignCarRequest {
    String accountID;
    List<String> cars;
}
