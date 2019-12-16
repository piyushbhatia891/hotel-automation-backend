package com.sahaj.soft.hotel_automation.utils;

import com.sahaj.soft.hotel_automation.commands.BillService;
import com.sahaj.soft.hotel_automation.commands.BillServiceImpl;
import com.sahaj.soft.hotel_automation.model.SensorModel;

public class CommonUtilsImpl  implements CommonUtils{
	BillService billService;
	private static int mainCorridorPower;
	private int subCorridorPower;
	private int maxBill;
	/*
	 * TODO-Please make this class singleton
	 */
	public CommonUtilsImpl() {
		this.billService=new BillServiceImpl();
	}

	@Override
	public int calculateTotalBill(SensorModel sensorModel) {
		mainCorridorPower = billService.getTotalBillForMainCorridor(sensorModel);
		subCorridorPower = billService.getTotalBillForSubCorridor(sensorModel);
		maxBill=sensorModel.getFloor().getMainCorridors().size()*15+
			sensorModel.getFloor().getSubCorridors().size()*10;
		return maxBill-mainCorridorPower+subCorridorPower;
		
	}

}
