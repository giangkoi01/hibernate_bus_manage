package com.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Driver {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String level_driver;

    @OneToMany(mappedBy = "driver")
    private List<Assignment> assignments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getlevel_driver() {
        return level_driver;
    }

    public void setlevel_driver(String level_driver) {
        this.level_driver = level_driver;
    }

    public Driver(String name, String address, String phoneNumber, String level_driver) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.level_driver = level_driver;
    }

    public Driver() {
    }

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", level_driver=" + level_driver + "]";
	}
    
    
}
