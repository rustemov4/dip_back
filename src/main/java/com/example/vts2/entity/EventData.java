package com.example.vts2.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "eventdata")
@Data
@IdClass(EventDataId.class)
public class EventData {
    @Id
    @Column(name = "accountID")
    String accountID;
    @Id
    @Column(name = "deviceID")
    String deviceID;
    @Id
    @Column(name = "timestamp")
    int timestamp;
    @Id
    @Column(name = "statuscode")
    int statuscode;
    @Column(name = "latitude")
    Double latitude;
    @Column(name = "longitude")
    Double longitude;
    @Column(name = "address")
    String address;
    @Column(name = "streetaddress")
    String streetaddress;
    @Column(name = "driverID")
    String driverID;
    @Column(name = "city")
    String city;
    @Column(name = "country")
    String country;
    @Column(name = "postalcode")
    String postalcode;
    @Column(name = "speedKPH")
    Double speedKPH;
}
