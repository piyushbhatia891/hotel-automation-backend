package com.sahaj.soft.hotel_automation.model;

import com.sahaj.soft.hotel_automation.states.StateContext;

public class Electronics {

	public int id;
	public ElectronicsDeviceGroup electronicsDeviceGroup;
	public StateContext deviceStatus;
	public Electronics(int id,ElectronicsDeviceGroup electronicsDeviceGroup) {
        this.id = id;
        this.electronicsDeviceGroup=electronicsDeviceGroup;
        this.deviceStatus=new StateContext(null,id,electronicsDeviceGroup);
    }
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public StateContext getDeviceStatus() {
		return deviceStatus;
	}


	public void setDeviceStatus(StateContext deviceStatus) {
		this.deviceStatus = deviceStatus;
	}


	public ElectronicsDeviceGroup getElectronicsDeviceGroup() {
		return electronicsDeviceGroup;
	}

	public void setElectronicsDeviceGroup(ElectronicsDeviceGroup electronicsDeviceGroup) {
		this.electronicsDeviceGroup = electronicsDeviceGroup;
	}

	public void swicthOn() {
		deviceStatus.update();
	}

	public void switchOff() {
		deviceStatus.update();
	}	
}
