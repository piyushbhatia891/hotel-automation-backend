package com.sahaj.soft.hotel_automation.eventsReceiver;

import com.sahaj.soft.hotel_automation.model.SensorModel;
import com.sahaj.soft.hotel_automation.utils.CommonUtils;
import com.sahaj.soft.hotel_automation.utils.CommonUtilsImpl;

public class BillSubscriber implements Observer {

	CommonUtils commonUtils;
	public BillSubscriber(){
		this.commonUtils=new CommonUtilsImpl();
	}
	public void update(SensorModel sensorModel) {
		System.out.println("Calculating bill="+ commonUtils.calculateTotalBill(sensorModel));
	}
	

}
