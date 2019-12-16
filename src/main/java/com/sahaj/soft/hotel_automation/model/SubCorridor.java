package com.sahaj.soft.hotel_automation.model;

import java.util.List;

public class SubCorridor extends Corridor{

	public int subCorridorId;
	public List<AirConditioner> airConditioner;
	public List<Light> light;
	public SubCorridor(int subCorridorId,List<AirConditioner> airConditioners,List<Light> lights){
		this.subCorridorId=subCorridorId;
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

	public int getSubCorridorId() {
		return subCorridorId;
	}

	public void setSubCorridorId(int subCorridorId) {
		this.subCorridorId = subCorridorId;
	}
	
}
