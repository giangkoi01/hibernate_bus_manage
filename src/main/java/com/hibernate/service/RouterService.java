package com.hibernate.service;

import java.util.List;

import com.hibernate.Main;
import com.hibernate.model.Driver;
import com.hibernate.model.Router;
import com.hibernate.repository.RouterRepository;

public class RouterService {
	RouterRepository routerRepository = new RouterRepository();
	
	public List<Router> getAll(){
		return routerRepository.getAll();
	}
	
	public boolean insert(Router router) {
		List<Router> routers = routerRepository.getAll();
		int id = -1;
		if(routers.size() == 0) {
			id = 100;
		}else {
			id = routers.get(0).getId() + 1;
		}
		router.setId(id);
		
		return routerRepository.insertRouter(router);
	}
	
	public Router findRouterId(int routerId) {
        for (Router router : Main.routers) {
            if (router.getId() == routerId)
                return router;
        }
        return null;
    }
}
