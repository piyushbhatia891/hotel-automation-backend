package com.sahaj.soft.hotel_automation.events;

import java.util.ArrayList;
import java.util.List;

import com.sahaj.soft.hotel_automation.eventsReceiver.Observer;
import com.sahaj.soft.hotel_automation.model.Bill;

public class EventPublishers implements Subject{
	private List<Observer> observers = new ArrayList();

	public void attach(Observer observer) {
		observers.add(observer);
		
	}

	public void detach(Observer observer) {
		observers.remove(observer);
		
	}

	public void notifyUpdate(Bill bill) {
		for(Observer observer: observers) {
			observer.update(bill);
        }
		
	}

}
