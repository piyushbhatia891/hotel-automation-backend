package com.sahaj.soft.hotel_automation.commands;

import com.sahaj.soft.hotel_automation.events.EventPublishers;
import com.sahaj.soft.hotel_automation.eventsReceiver.BillSubscriber;
import com.sahaj.soft.hotel_automation.model.AirConditioner;
import com.sahaj.soft.hotel_automation.model.Electronics;
import com.sahaj.soft.hotel_automation.model.SensorModel;
import com.sahaj.soft.hotel_automation.states.OnState;
import com.sahaj.soft.hotel_automation.utils.CommonUtils;
import com.sahaj.soft.hotel_automation.utils.CommonUtilsImpl;

public class CommandServiceImpl implements CommandService {

	SensorModel sensorModel;
	EventPublishers publishers; 
	BillSubscriber subscribers;
	ICommand iCommand=null;
	public CommandServiceImpl(SensorModel model){
		super();
		this.sensorModel=model;
		initializeUtilsAndObservers();
	}

	private void initializeUtilsAndObservers() {
		this.publishers=new EventPublishers();
		this.subscribers=new BillSubscriber();
		this.publishers.attach(subscribers);
	}
	
	@Override
	public void initiateCommandForElectronicDevice() {
		/*
		 * TODO- Bridge pattern can be used here for different classes
		 */
		switch(sensorModel.device.electronicsDeviceGroup){
			case AIR_CONDITIONER:
				iCommand=new ACCommands(sensorModel);
				break;
			case LIGHT:
				iCommand=new LightCommand(sensorModel);
				break;
			default:
				break;
				
		}
		iCommand.command();
		//publishers.notifyUpdate(sensorModel);
		
	}
/*
	public  void executeCommandsForLight() {
		switch(command){
		case SWICTH_ON:
		if(commonUtils.calculateTotalBill(sensorModel)>0)
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
		publishers.notifyUpdate(sensorModel);
	}

	private void checkIfDeviceCanBeSwitchedOffToKeepBillIntact() {
		sensorModel.getFloor().getSubCorridors().stream()
		.findAny()
		.ifPresent(val->
					{
						val.getAirConditioner()
				.stream()
				.filter(ac->ac.getDeviceStatus().getDeviceState().equals(OnState.instance()))
				.forEach(acVal->acVal.switchOff());
				});
		if(commonUtils.calculateTotalBill(sensorModel)>0)
			device.swicthOn();
		/*else{
			if(retryCounts!=3){
				checkIfDeviceCanBeSwitchedOffToKeepBillIntact();
				retryCounts++;
			}
		}
	}*/
	
/*
	
	public void executeCommandsForAirConditioner() {
		switch(command){
		case SWICTH_ON:
			device.swicthOn();
			break;
		case SWITCH_OFF:
			device.switchOff();
			break;
		}
	}
*/
}
