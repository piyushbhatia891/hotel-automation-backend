package com.sahaj.soft.hotel_automation.commands;

import com.sahaj.soft.hotel_automation.model.Light;

public class LightCommands implements ICommand{

	Light light;
	Commands command;
	
	public LightCommands(Light light,Commands command){
		super();
		this.light=light;
		this.command=command;
	}
	public void command() {
		System.out.println("switching on light");
		switch(command){
		case SWICTH_ON:
			light.swicthOn();
			break;
		case SWITCH_OFF:
			light.switchOff();
			break;
		default:
			break;
		}
		
	}
	
}
