package com.sahaj.soft.hotel_automation.commands;

import com.sahaj.soft.hotel_automation.events.EventPublishers;
import com.sahaj.soft.hotel_automation.model.Hotel;
import com.sahaj.soft.hotel_automation.model.Light;
import com.sahaj.soft.hotel_automation.model.SensorModel;
import com.sahaj.soft.hotel_automation.states.OffState;
import com.sahaj.soft.hotel_automation.states.OnState;

public class LightCommands implements ICommand{

	SensorModel sensorModel;
	Light light;
	Commands command;
	EventPublishers publishers=new EventPublishers();
	public LightCommands(SensorModel model,Commands command){
		super();
		this.command=command;
		this.sensorModel=model;
	}
	public void command() {
		System.out.println("Light related commands");
		switch(command){
		case SWICTH_ON:
			int mainCorridorPower=sensorModel.getFloor().getMainCorridors().stream()
				.mapToInt(corridor->{
					return (int) (corridor.getAirConditioner().stream()
					.filter(ac->ac.getDeviceStatus().equals(OnState.instance()))
					.count()*10)+
					(int) (corridor.getLight().stream()
					.filter(light->light.getDeviceStatus().equals(OnState.instance()))
					.count()*5);
					
				}).sum();
			int subCorridorPower=sensorModel.getFloor().getSubCorridors().stream()
			.mapToInt(corridor->{
				return (int) (corridor.getAirConditioner().stream()
				.filter(ac->ac.getDeviceStatus().equals(OnState.instance()))
				.count()*10)+
				(int) (corridor.getLight().stream()
				.filter(light->light.getDeviceStatus().equals(OnState.instance()))
				.count()*5);
				
			}).sum();
			int maxBill=sensorModel.getFloor().getMainCorridors().size()*15+
					sensorModel.getFloor().getSubCorridors().size()*10;
			if(mainCorridorPower+subCorridorPower<maxBill)
				light.swicthOn();
			else
				sensorModel.getFloor().getSubCorridors().stream()
				.findAny()
				.ifPresent(val->
							{
								val.getAirConditioner()
						.stream()
						.filter(ac->ac.getDeviceStatus().equals(OnState.instance()))
						.forEach(acVal->acVal.setDeviceStatus(acVal.getDeviceStatus()));
						});		
								
			publishers.notifyUpdate(sensorModel);
			break;
		case SWITCH_OFF:
			light.switchOff();
			break;
		default:
			break;
		}
		
	}
	
}
