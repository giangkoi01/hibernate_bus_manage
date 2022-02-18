package com.hibernate.controller;


import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.hibernate.Main;
import com.hibernate.model.Assignment;
import com.hibernate.model.Driver;
import com.hibernate.model.Router;
import com.hibernate.service.AssignmentService;
import com.hibernate.service.DriverService;
import com.hibernate.service.RouterService;	


public class AssignmentController {		
	AssignmentService assignmentService = new AssignmentService();
	DriverService driverService = new DriverService();
	RouterService routerService = new RouterService();
	
	public void inputAssignment() {
		System.out.println("nhập số lái xe cần phân công");
		int driverNumber = -1;
		do {
			try {
				driverNumber = new Scanner(System.in).nextInt();
				if (driverNumber > 0) {
					if (driverNumber <= Main.drivers.size()) {
						break;
					}
					System.out.println("số lượng phân công phải nhỏ hơn số lượng lái xe");
				}
				System.out.println("số lượng lái xe cần phân công phải lớn hơn 0");
			} catch (InputMismatchException e) {
				System.out.println("số lượng lái xe phải là 1 số");
			}
		} while (true);

		for (int i = 0; i < driverNumber; i++) {
			System.out.println("mời bạn nhập id lái xe");
			int DriverId = -1;
			Driver driver = null;
			do {
				try {
					DriverId = new Scanner(System.in).nextInt();
					driver = driverService.findDriverById(DriverId);
					if (driver != null) {
						break;
					}
					System.out.println("lái xe không tồn tại, mời nhập lại");
				} catch (InputMismatchException e) {
					System.out.println("id phải là 1 số");
				}
			} while (true);

			System.out.println("nhập số tuyến");
			int routerNumber = -1;
			do {
				try {
					routerNumber = new Scanner(System.in).nextInt();
					if (routerNumber > 0) {
						if (routerNumber <= Main.routers.size()) {
							break;
						}
						System.out.println("nhập lại số lượng tuyến");
					}
					System.out.println("số lượng tuyến phải lớn hơn 0");
				} catch (InputMismatchException e) {
					System.out.println("số lượng tuyến phải là 1 số");
				}
			} while (true);

			Router router = null;
			int turnNumber = -1;
			for (int j = 0; j < routerNumber; j++) {

				System.out.println("nhập id tuyến");
				do {
					int routerId = new Scanner(System.in).nextInt();
					router = routerService.findRouterId(routerId);
					if (router != null) {
						break;
					}
					System.out.println("tuyến không tồn tại, nhập lại");
				} while (true);

				System.out.println("nhập số lượt đi");
				do {
					turnNumber = new Scanner(System.in).nextInt();
					if (turnNumber  <= 15) {
						break;
					}
					System.out.println("tổng số lượt không quá 15");
				} while (true);
				
				Assignment assignment = new Assignment(driver, router, turnNumber);
				Main.assignments.add(assignment);
				assignmentService.insertAssignment(assignment);
				
			}
		}
	}
	
	public void totalDistance() {
		for (Assignment assignment : Main.assignments) {
			System.out.println("tổng khoảng chạy xe trong ngày trong ngày của " + assignment.getDriver().getName()
					+ " là :" + assignment.getDistance());
		}

	}
	
	public void showListAssignment() {
		List<Assignment> assignments = assignmentService.getAll();
		for (Assignment assignment : assignments) {
			System.out.println(assignment);
		}
	}
	
	public List<Assignment> getAll(){
		return assignmentService.getAll();
	}
	

	public void sortByName() {
		Collections.sort(Main.assignments, (o1, o2) -> o1.getDriver().getName().compareTo(o2.getDriver().getName()));

		for (Assignment assignment : Main.assignments) {
			System.out.println(assignment);
		}
	}
}
