package com.sahaj.soft.hotel_automation.commands;

import com.sahaj.soft.hotel_automation.model.SensorModel;
import com.sahaj.soft.hotel_automation.states.OnState;

public class BillServiceImpl implements BillService {

	@Override
	public int getTotalBillForSubCorridor(SensorModel sensorModel) {
		int subCorridorPower=sensorModel.getFloor().getSubCorridors().stream()
		.mapToInt(corridor->{
			int acPower=(int) (corridor.getAirConditioner().stream()
					.filter(ac->ac.getDeviceStatus().getDeviceState().equals(OnState.instance()))
					.count()*10);
			int lightPower=(int) (corridor.getLight().stream()
					.filter(light->light.getDeviceStatus().getDeviceState().equals(OnState.instance()))
					.count()*5);
			return acPower+lightPower;
			
		}).sum();
		return subCorridorPower;
	}

	@Override
	public int getTotalBillForMainCorridor(SensorModel sensorModel) {
		int mainCorridorPower=sensorModel.getFloor().getMainCorridors().stream()
		.mapToInt(corridor->{
			int acPower=(int) (corridor.getAirConditioner().stream()
					.filter(ac->ac.getDeviceStatus().getDeviceState().equals(OnState.instance()))
					.count()*10);
			int lightPower=(int) (corridor.getLight().stream()
					.filter(light->light.getDeviceStatus().getDeviceState().equals(OnState.instance()))
					.count()*5);
			return acPower+lightPower;
			
			
		}).sum();
		return mainCorridorPower;
	}
}
