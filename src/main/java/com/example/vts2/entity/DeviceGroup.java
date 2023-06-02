package com.example.vts2.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "devicegroup")
@Data
@IdClass(DeviceGroupId.class)
public class DeviceGroup {
    @Id
    String accountID;
    @Id
    String groupID;
    @Column(name = "displayname")
    String displayname;
}
