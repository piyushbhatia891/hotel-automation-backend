package com.sahaj.soft.hotel_automation.states;

import com.sahaj.soft.hotel_automation.model.ElectronicsDeviceGroup;

public class StateContext {
	private DeviceState deviceState;
	private int deviceId;
	public StateContext(DeviceState deviceState, int deviceId,ElectronicsDeviceGroup electronicsDeviceGroup) 
    {
        super();
        this.deviceState = deviceState;
        this.deviceId = deviceId;
         
        if(deviceState == null) {
        	//We need to switch on AC's on by default and switch off the ligts 
        	if(electronicsDeviceGroup.equals(electronicsDeviceGroup.AIR_CONDITIONER))
        		this.deviceState = OnState.instance();
        	else
        		this.deviceState = OffState.instance();
        }
    }
 
	
    public DeviceState getDeviceState() {
		return deviceState;
	}


	public void setDeviceState(DeviceState deviceState) {
		this.deviceState = deviceState;
	}


	public void setCurrentState(DeviceState deviceState) {
        this.deviceState = deviceState;
    }
    
     
    public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public void update() {
        deviceState.updateState(this);
    }

}
