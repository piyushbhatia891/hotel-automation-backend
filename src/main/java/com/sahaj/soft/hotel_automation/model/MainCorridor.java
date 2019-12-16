package com.sahaj.soft.hotel_automation.model;

import java.util.List;

public class MainCorridor extends Corridor{
	public int mainCorridorId;
	public List<AirConditioner> airConditioner;
	public List<Light> light;
	public MainCorridor(int mainCorridorId,List<AirConditioner> airConditioners,List<Light> lights){
		this.mainCorridorId=mainCorridorId;
		this.airConditioner=airConditioners;
		this.light=lights;
	}
	public List<AirConditioner> getAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(List<AirConditioner> airConditioner) {
		this.airConditioner = airConditioner;
	}

	public List<Light> getLight() {
		return light;
	}

	public void setLight(List<Light> light) {
		this.light = light;
	}

	public int getMainCorridorId() {
		return mainCorridorId;
	}

	public void setMainCorridorId(int mainCorridorId) {
		this.mainCorridorId = mainCorridorId;
	}

	
}
