package com.sahaj.soft.hotel_automation.eventsReceiver;

import com.sahaj.soft.hotel_automation.model.Bill;

public interface Observer 
{
    public void update(Bill bill);
}