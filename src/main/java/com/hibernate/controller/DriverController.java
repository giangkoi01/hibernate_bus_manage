package com.hibernate.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.hibernate.Main;
import com.hibernate.model.Driver;
import com.hibernate.service.DriverService;


public class DriverController {
	DriverService driverService = new DriverService();
	
	public void inputDriver() {
		System.out.println("mời bạn nhập tên:");
		String name = new Scanner(System.in).nextLine();
		System.out.println("nhập địa chỉ:");
		String address = new Scanner(System.in).nextLine();
		System.out.println("nhập số điện thoại");
		String phoneNumber = new Scanner(System.in).nextLine();
		
		String level = null;
		do {
			try {
				System.out.println("mời bạn chọn trình độ");
				System.out.println("1.loại A");
				System.out.println("2.loại B");
				System.out.println("3.loại C");
				System.out.println("4.loại D");
				System.out.println("5.loại E");
				System.out.println("6.loại F");
				int choose = new Scanner(System.in).nextInt();
				if(choose > 0 && choose < 7) {
					switch (choose) {
					case 1:
						level = "loại A";
						break;
					case 2:
						level = "loại B";
						break;
					case 3:
						level = "loại C";
						break;
					case 4:
						level = "loại D";
						break;
					case 5:
						level = "loại E";
						break;
					case 6:
						level = "loại F";
						break;
					}
					break;
				}
				System.out.println("trình độ vừa nhập k hợp lệ, nhập lại");
			} catch (InputMismatchException e) {
				System.out.println("trình độ phải là 1 số");
			}
		} while (true);
		Driver driver = new Driver(name, address, phoneNumber, level);
		Main.drivers.add(driver);
		
		if(driverService.insert(driver)) {
			System.out.println("thêm thành công");
		}else {
			System.out.println("thêm thất bại");
		}
	}
	
	public void insertListDriver() {
		System.out.println("Nhập số lượng lái xe");
		int driverNumber = -1;
		do {
			try {
				driverNumber = new Scanner(System.in).nextInt();
				if(driverNumber >= 0) {
					break;
				}
				System.out.println("số điện thoại phải lớn hơn 0");
			} catch (InputMismatchException e) {
				System.out.println("số điện thoại phải là 1 số");
			}
		} while (true);
		
		for (int i = 0; i < driverNumber; i++) {
			this.inputDriver();
		}
	}
	
	public List<Driver> getAll(){
		return driverService.getAll();
	}
	
	public void showListDriver() {
		List<Driver> drivers = driverService.getAll();
		for (Driver driver : drivers) {
			System.out.println(driver);
		}
	}

}
