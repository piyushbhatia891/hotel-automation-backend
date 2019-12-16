package com.sahaj.soft.hotel_automation.commands;

import com.sahaj.soft.hotel_automation.model.Electronics;
import com.sahaj.soft.hotel_automation.model.SensorModel;
import com.sahaj.soft.hotel_automation.states.OnState;
import com.sahaj.soft.hotel_automation.utils.CommonUtils;
import com.sahaj.soft.hotel_automation.utils.CommonUtilsImpl;

public class LightCommand implements ICommand{

	
	/*
	 * TODO- This class can be used as a bridge pattern
	 */
	Electronics device;
	Commands command;
	CommonUtils commonUtils=null;
	SensorModel model=null;
	public LightCommand(SensorModel sensorModel){
		super();
		this.model=sensorModel;
		this.device=sensorModel.getDevice();
		this.command=sensorModel.getCommand();
		this.commonUtils=new CommonUtilsImpl();
	}
	public void command() {
		System.out.println("Light related commands");
		switch(command){
		case SWICTH_ON:
		if(commonUtils.calculateTotalBill(model)>0)
			device.swicthOn();
		else{
			checkIfDeviceCanBeSwitchedOffToKeepBillIntact();
		}
		break;
		case SWITCH_OFF:
			device.switchOff();
			break;
		default:
			break;
		}
		
	}
	
	private void checkIfDeviceCanBeSwitchedOffToKeepBillIntact() {
		model.getFloor().getSubCorridors().stream()
		.findAny()
		.ifPresent(val->
					{
						val.getAirConditioner()
				.stream()
				.filter(ac->ac.getDeviceStatus().getDeviceState().equals(OnState.instance()))
				.forEach(acVal->acVal.switchOff());
				});
		if(commonUtils.calculateTotalBill(model)>0)
			device.swicthOn();
		/*else{
			if(retryCounts!=3){
				checkIfDeviceCanBeSwitchedOffToKeepBillIntact();
				retryCounts++;
			}
		}*/
	}

	
}
