package com.sahaj.soft.hotel_automation.commands;

import com.sahaj.soft.hotel_automation.model.AirConditioner;
import com.sahaj.soft.hotel_automation.model.Electronics;
import com.sahaj.soft.hotel_automation.model.SensorModel;

public class ACCommands implements ICommand{
	/*
	 * This class is used as a bridge pattern
	 */
	Electronics device;
	Commands command;
	SensorModel model=null;
	public ACCommands(SensorModel sensorModel){
		super();
		this.model=sensorModel;
		this.device=sensorModel.getDevice();
		this.command=sensorModel.getCommand();
	}
	public void command() {
		//Commands operation for AC
		System.out.println("Ac related commands");
		switch(command){
		case SWICTH_ON:
			device.swicthOn();
			break;
		case SWITCH_OFF:
			device.switchOff();
			break;
		default:
			break;
		}
		
	}
	
}
