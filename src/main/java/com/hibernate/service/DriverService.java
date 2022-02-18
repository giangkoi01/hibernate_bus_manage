package com.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.Main;
import com.hibernate.model.Driver;
import com.hibernate.repository.DriverRepository;

public class DriverService {
	DriverRepository driverRepository = new DriverRepository();
	public List<Driver> getAll(){
		return driverRepository.getAll();
	}
	
	public boolean insert(Driver driver) {
		List<Driver> drivers = driverRepository.getAll();
		int id = -1;
		if(drivers.size() == 0) {
			id = 10000;
		}else {
			id = drivers.get(0).getId() + 1;
		}
		driver.setId(id);
		if(driver.getName() == null) {
			return false;
		}
		if(driver.getAddress() == null) {
			return false;
		}
		if(driver.getPhoneNumber() == null) {
			return false;
		}
		if(driver.getlevel_driver() == null) {
			return false;
		}
		return driverRepository.insert(driver);
	}
	
	public Driver findDriverById(int driverId) {
        for (Driver driver : Main.drivers) {
            if (driver.getId() == driverId)
                return driver;
        }
        return null;
    }
	
}
