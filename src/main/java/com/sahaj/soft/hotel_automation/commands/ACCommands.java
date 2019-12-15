package com.sahaj.soft.hotel_automation.commands;

import com.sahaj.soft.hotel_automation.model.AirConditioner;

public class ACCommands implements ICommand{

	AirConditioner ac;
	Commands command;
	public int subCorridorId;
	public int mainCorridorId;
	public ACCommands(AirConditioner ac,Commands command,int subCorridorId,int mainCorridorId){
		super();
		this.ac=ac;
		this.command=command;
		this.mainCorridorId=mainCorridorId;
		this.subCorridorId=subCorridorId;
	}
	public void command() {
		System.out.println("Ac related commands");
		switch(command){
		case SWICTH_ON:
			ac.swicthOn();
			break;
		case SWITCH_OFF:
			ac.switchOff();
			break;
		default:
			break;
		}
		
	}
	
}
