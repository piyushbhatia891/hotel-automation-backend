package com.sahaj.soft.hotel_automation.eventsReceiver;

import com.sahaj.soft.hotel_automation.model.Bill;

public class BillSubscriber implements Observer {

	public void update(Bill bill) {
		// TODO- Change to facade pattern
		System.out.println("Calculating bill");
		
	}
	

}
