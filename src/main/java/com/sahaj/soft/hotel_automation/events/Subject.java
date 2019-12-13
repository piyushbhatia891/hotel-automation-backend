package com.sahaj.soft.hotel_automation.events;

import com.sahaj.soft.hotel_automation.eventsReceiver.Observer;
import com.sahaj.soft.hotel_automation.model.Bill;

public interface Subject {
	public void attach(Observer o);
    public void detach(Observer o);
    public void notifyUpdate(Bill m);
}
