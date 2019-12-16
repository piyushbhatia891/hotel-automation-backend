package com.sahaj.soft.hotel_automation.model;

import com.sahaj.soft.hotel_automation.commands.Commands;

public class SensorModel {
	
	public Floor floor;
	public Electronics device;
	public Commands command;
	
	public Electronics getDevice() {
		return device;
	}
	public void setDevice(Electronics device) {
		this.device = device;
	}
	public Commands getCommand() {
		return command;
	}
	public void setCommand(Commands command) {
		this.command = command;
	}
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
}
