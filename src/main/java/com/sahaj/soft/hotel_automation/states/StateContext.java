package com.sahaj.soft.hotel_automation.states;

public class StateContext {
	private DeviceState deviceState;
	private int deviceId;
	private OffState currentState;
	public StateContext(DeviceState currentState, int deviceId) 
    {
        super();
        this.deviceState = currentState;
        this.deviceId = deviceId;
         
        if(deviceState == null) {
            this.deviceState = OffState.instance();
        }
    }
 
    public DeviceState getCurrentState() {
        return currentState;
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
        currentState.updateState(this);
    }

}
