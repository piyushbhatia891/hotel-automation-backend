package com.sahaj.soft.hotel_automation.states;

public class OnState implements DeviceState{
	//Singleton
    private static OnState instance = new OnState();
 
    private OnState() {}
 
    public static OnState instance() {
        return instance;
    }
     
    //Business logic and state transition
    public void updateState(StateContext ctx) 
    {
        System.out.println("Package is shipped !!");
        ctx.setCurrentState(OffState.instance());
    }

}
