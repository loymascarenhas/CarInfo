package com.cardata.rest;

public class Car {
	private long id=0;
	private int year;
	private String make;
	private String type;
	
//	public Car(int year, String make, String type) {
//		this.year = year;
//		this.make = make;
//		this.type = type;
//	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}
	
	protected void setId(long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public String getType() {
		return type;
	}
}