package com.hibernate;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.hibernate.controller.AssignmentController;
import com.hibernate.controller.DriverController;
import com.hibernate.controller.RouterController;
import com.hibernate.model.Assignment;
import com.hibernate.model.Driver;
import com.hibernate.model.Router;
import com.hibernate.util.DataUtil;


public class Main {
	public static List<Driver> drivers = new ArrayList<Driver>();
	public static List<Router> routers = new ArrayList<Router>();
	public static List<Assignment> assignments = new ArrayList<Assignment>();
	
	public static DriverController driverController = new DriverController();
	public static RouterController routerController = new RouterController();
	public static AssignmentController assignmentController = new AssignmentController();
	
	private static void initializeData() {
		List<Driver> driverList = driverController.getAll();
		drivers = DataUtil.isNullOrEmpty(driverList) ? new ArrayList<Driver>() : (ArrayList<Driver>) driverList;
		
		List<Router> routerList = routerController.getAll();
		routers = DataUtil.isNullOrEmpty(routerList) ? new ArrayList<Router>() : (ArrayList<Router>) routerList;
		
		List<Assignment> assignmentList = assignmentController.getAll();
		assignments = DataUtil.isNullOrEmpty(assignmentList) ? new ArrayList<Assignment>() : (ArrayList<Assignment>) assignmentList;
	}
	
	public static void main(String[] args) {
		initializeData();
		menu();
	}

	public static void menu() {
		do {
			int functionChoice = functionChoice();
			switch (functionChoice) {
			case 1:
				driverController.insertListDriver();
				break;
			case 2:
				driverController.showListDriver();
				break;
			case 3:
				routerController.insertListRouter();
				break;
			case 4:
				routerController.showListRouter();
				break;
			case 5:
				assignmentController.inputAssignment();
				break;
			case 6:
				assignmentController.showListAssignment();
				break;
			case 7:
				assignmentController.sortByName();
				break;
			case 8:
				assignmentController.totalDistance();
				break;
			}
		} while (true);
	}

	public static int functionChoice() {
		System.out.println("Qu???n l?? ph??n c??ng xe bus");
		System.out.println("1, nh???p danh s??ch lai xe m???i:");
		System.out.println("2, in danh s??ch lai xe");
		System.out.println("3,nh???p danh s??ch tuy???n m???i:");
		System.out.println("4,in danh s??ch tuy???n m???i:");
		System.out.println("5,nh???p l??i xe c???n ph??n c??ng");
		System.out.println("6, in danh s??ch l??i xe ???? ph??n c??ng");
		System.out.println("7,s???p x???p danh s??ch l??i xe theo t??n:");
		System.out.println("8,t??nh t???ng kho???ng c??ch l??i xe trong ng??y");
		System.out.println("m???i b???n ch???n ch???c n??ng:");

		do {
			try {
				int choose = new Scanner(System.in).nextInt();
				if (choose > 0 && choose < 10) {
					return choose;
				}
				System.out.println("ch???c n??ng ch??? t??? 1 ?????n 7");
			} catch (InputMismatchException e) {
				System.out.println("ch???c n??ng ph???i l?? 1 s???");
			}
		} while (true);
	}
}
