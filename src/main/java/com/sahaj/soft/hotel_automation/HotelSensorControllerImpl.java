package com.sahaj.soft.hotel_automation;

import com.sahaj.soft.hotel_automation.commands.CommandService;
import com.sahaj.soft.hotel_automation.commands.CommandServiceImpl;
import com.sahaj.soft.hotel_automation.commands.Commands;import com.sahaj.soft.hotel_automation.model.Electronics;
import com.sahaj.soft.hotel_automation.model.Floor;
import com.sahaj.soft.hotel_automation.model.SensorModel;

public class HotelSensorControllerImpl implements HotelSensorController{

	CommandService commandService;
	
	@Override
	public void verifySensorDataAndUpdateOperationOnDevice(Floor floor, Electronics electronics,Commands command) {
		SensorModel model=new SensorModel();
		model.setFloor(floor);
		model.setCommand(command);
		model.setDevice(electronics);
		this.commandService=new CommandServiceImpl(model);
		commandService.initiateCommandForElectronicDevice();
	}	
}
