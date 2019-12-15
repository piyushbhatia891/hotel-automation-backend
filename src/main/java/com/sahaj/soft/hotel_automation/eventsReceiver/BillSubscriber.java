package com.sahaj.soft.hotel_automation.eventsReceiver;

import com.sahaj.soft.hotel_automation.model.SensorModel;

public class BillSubscriber implements Observer {

	public void update(SensorModel sensorModel) {
		// TODO- Change to facade pattern
		System.out.println("Calculating bill");
		
	}
	

}
