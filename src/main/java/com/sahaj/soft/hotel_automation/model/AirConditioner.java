package com.sahaj.soft.hotel_automation.model;

import com.sahaj.soft.hotel_automation.states.StateContext;

public class AirConditioner extends Electronics {

	public int acId;
	public StateContext deviceStatus;
	public AirConditioner() {
		this.deviceStatus=new StateContext(null,electronicsId);
	}
	
	
	public StateContext getDeviceStatus() {
		return deviceStatus;
	}


	public void setDeviceStatus(StateContext deviceStatus) {
		this.deviceStatus = deviceStatus;
	}


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
