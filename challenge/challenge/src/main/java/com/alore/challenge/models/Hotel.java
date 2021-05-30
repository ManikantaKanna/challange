package com.alore.challenge.models;

import java.util.List;



public class Hotel {
	private int id;
	private String name;
	private int rating;
	private List<Comments> comments;
	private int locationId;
	private List<Integer> amenetyId;
	private int availableRooms;
	
	
	
	public int getAvailableRooms() {
		return availableRooms;
	}
	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}
	private String adress;
	
	
	public List<Integer> getAmenetyId() {
		return amenetyId;
	}
	public void setAmenetyId(List<Integer> amenetyId) {
		this.amenetyId = amenetyId;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
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
	

}
