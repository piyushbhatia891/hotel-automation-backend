package com.sahaj.soft.hotel_automation.states;

public class OffState implements DeviceState{
	//Singleton
    private static OffState instance = new OffState();
 
    private OffState() {}
 
    public static OffState instance() {
        return instance;
    }
     
    //Business logic and state transition
    public void updateState(StateContext ctx) 
    {
        System.out.println("Swicthing On ");
        ctx.setCurrentState(OnState.instance());
    }

}
