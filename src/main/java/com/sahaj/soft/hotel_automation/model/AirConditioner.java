package com.sahaj.soft.hotel_automation.model;

public class AirConditioner extends Electronics {

	public int acId;

	public int getAcId() {
		return acId;
	}

	public void setAcId(int acId) {
		this.acId = acId;
	}
	public void swicthOn() {
		System.out.println("Switching On the AC");
		
	}

	public void switchOff() {
		System.out.println("Switching Off the AC");
		
	}
}
