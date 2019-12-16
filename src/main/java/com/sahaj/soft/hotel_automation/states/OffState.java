package com.sahaj.soft.hotel_automation.states;

public class OffState implements DeviceState{
    private static OffState instance = new OffState();
    
    private OffState() {}
 
    public static OffState instance() {
        return instance;
    }
     
/*
 * (non-Javadoc)
 * @see com.sahaj.soft.hotel_automation.states.DeviceState#updateState(com.sahaj.soft.hotel_automation.states.StateContext)
 * Updating the status of the device
 */
    public void updateState(StateContext ctx) 
    {
        System.out.println("Swicthing On the device");
        ctx.setCurrentState(OnState.instance());
    }

}
