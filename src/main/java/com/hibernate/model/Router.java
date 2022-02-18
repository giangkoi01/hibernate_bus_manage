package com.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Router {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int distance;
    private int stopPoint;

    @OneToMany(mappedBy = "router",cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Assignment> assignments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(int stopPoint) {
        this.stopPoint = stopPoint;
    }

    public Router() {
    }

    public Router(int distance, int stopPoint) {
        this.distance = distance;
        this.stopPoint = stopPoint;
    }

	@Override
	public String toString() {
		return "Router [id=" + id + ", distance=" + distance + ", stopPoint=" + stopPoint + "]";
	}
   
}
