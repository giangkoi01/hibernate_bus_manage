package com.hibernate.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.hibernate.Main;
import com.hibernate.model.Router;
import com.hibernate.service.RouterService;

public class RouterController {
	RouterService routerService = new RouterService();
	
	public void inputRouter() {
		System.out.println("nhập khoảng cách");
		int distance = -1;
		do {
			try {
				distance = new Scanner(System.in).nextInt();
				if(distance > 0) {
					break;
				}
				System.out.println("khoảng cách phải lớn hơn 0");
			} catch (InputMismatchException e) {
				System.out.println("khoảng cách phải là 1 số");
			}
		} while (true);
		
		System.out.println("nhập số điểm dừng");
		int stopPoint = -1;
		do {
			try {
				stopPoint = new Scanner(System.in).nextInt();
				if(stopPoint > 0) {
					break;
				}
				System.out.println("số điểm dừng phải lớn hơn 0");
			} catch (InputMismatchException e) {
				System.out.println("sô điểm dừng phải là 1 số");
			}
		} while (true);
		
		Router router = new Router(distance, stopPoint);
		Main.routers.add(router);
		
		if(routerService.insert(router)) {
			System.out.println("thêm thành công");
		}else {
			System.out.println("thêm thất bại");
		}
	}
	
	public void insertListRouter() {
		System.out.println("Nhập số lượng tuyến");
		int routerNumber = -1;
		do {
			try {
				routerNumber = new Scanner(System.in).nextInt();
				if(routerNumber >= 0) {
					break;
				}
				System.out.println("số điện thoại phải lớn hơn 0");
			} catch (InputMismatchException e) {
				System.out.println("số điện thoại phải là 1 số");
			}
		} while (true);
		
		for (int i = 0; i < routerNumber; i++) {
			this.inputRouter();
		}
	}
	
	public List<Router> getAll(){
		return routerService.getAll();
	}
	
	public void showListRouter() {
		List<Router> routers = routerService.getAll();
		for (Router router : routers) {
			System.out.println(router);
		}
	}
}
