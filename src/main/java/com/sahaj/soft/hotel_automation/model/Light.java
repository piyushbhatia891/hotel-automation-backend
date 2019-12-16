package com.sahaj.soft.hotel_automation.model;

import com.sahaj.soft.hotel_automation.states.StateContext;

public class Light extends Electronics {

	public Light(int lightId) {
		super(lightId,ElectronicsDeviceGroup.LIGHT);
	}
	
}
