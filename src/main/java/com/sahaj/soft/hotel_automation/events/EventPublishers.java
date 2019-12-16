package com.sahaj.soft.hotel_automation.events;

import java.util.ArrayList;
import java.util.List;

import com.sahaj.soft.hotel_automation.eventsReceiver.Observer;
import com.sahaj.soft.hotel_automation.model.Bill;
import com.sahaj.soft.hotel_automation.model.SensorModel;

public class EventPublishers implements Subject{
	private List<Observer> observers = new ArrayList();

	public void attach(Observer observer) {
		observers.add(observer);
		
	}

	public void detach(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyUpdate(SensorModel model) {
		for(Observer observer: observers) {
			observer.update(model);
        }
		
	}

}
