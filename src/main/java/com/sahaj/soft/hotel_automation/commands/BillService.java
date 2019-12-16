package com.sahaj.soft.hotel_automation.commands;

import com.sahaj.soft.hotel_automation.model.SensorModel;

public interface BillService {

	public int getTotalBillForSubCorridor(SensorModel sensorModel);
	public int getTotalBillForMainCorridor(SensorModel sensorModel);
}
