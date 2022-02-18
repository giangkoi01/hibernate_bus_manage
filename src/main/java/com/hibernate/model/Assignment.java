package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Assignment implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

	@Id
    @ManyToOne
    @JoinColumn(name = "router_id")
    private Router router;

    private int turnNumber;
    
    public float getDistance() {
    	return turnNumber*2*router.getDistance();
    }

    public Assignment(Driver driver, Router router, int turnNumber) {
        this.driver = driver;
        this.router = router;
        this.turnNumber = turnNumber;
    }

    public Assignment() {
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

	@Override
	public String toString() {
		return "Assignment [driver=" + driver + ", router=" + router + ", turnNumber=" + turnNumber + "]";
	}
    
    
}
