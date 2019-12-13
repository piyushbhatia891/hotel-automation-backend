package com.sahaj.soft.hotel_automation.model;

import com.sahaj.soft.hotel_automation.commands.Commands;

public class Light extends Electronics {

	public int lightId;

	public int getLightId() {
		return lightId;
	}

	public void setLightId(int lightId) {
		this.lightId = lightId;
	}

	public void swicthOn() {
		System.out.println("Switching On the light");
		
	}

	public void switchOff() {
		System.out.println("Switching Off the light");
		
	}

	
	
}
