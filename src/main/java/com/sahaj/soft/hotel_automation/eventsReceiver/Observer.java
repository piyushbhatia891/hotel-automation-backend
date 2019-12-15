package com.sahaj.soft.hotel_automation.eventsReceiver;

import com.sahaj.soft.hotel_automation.model.Bill;
import com.sahaj.soft.hotel_automation.model.SensorModel;

public interface Observer 
{
    public void update(SensorModel sensorModel);
}