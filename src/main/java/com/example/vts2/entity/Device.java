package com.example.vts2.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "device")
@Data
@IdClass(DeviceId.class)
public class Device {
    @Id
    String deviceID;
    @Id
    String accountID;
    @Column(name = "vehiclemake")
    String vehicleMake;
    @Column(name = "simphonenumber")
    String simPhoneNumber;
    @Column(name = "vehiclemodel")
    String vehicleModel;
    @Column(name = "equipmenttype")
    String equipmentType;
    @Column(name = "lastvalidlatitude")
    Double lastvalidlatitude;
    @Column(name = "lastvalidlongitude")
    Double lastvalidlongitude;
    @Column(name = "address")
    String address;
    @Column(name = "lastGPSTimestamp")
    int lastGPSTimestamp;
    @Column(name = "lastodometerKM")
    Double lastOdometerKM;
}
