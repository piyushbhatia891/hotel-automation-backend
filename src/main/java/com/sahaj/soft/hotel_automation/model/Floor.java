package com.sahaj.soft.hotel_automation.model;

import java.util.List;

public class Floor {

	int maximumBill;
	public int floorId;
	public List<MainCorridor> mainCorridors;
	public List<SubCorridor> subCorridors;
	
	
	public int getFloorId() {
		return floorId;
	}
	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}
	public int getMaximumBill() {
		return maximumBill;
	}
	public void setMaximumBill(int maximumBill) {
		this.maximumBill = mainCorridors.size()*15+subCorridors.size()*10;
	}
	public List<MainCorridor> getMainCorridors() {
		return mainCorridors;
	}
	public void setMainCorridors(List<MainCorridor> mainCorridors) {
		this.mainCorridors = mainCorridors;
	}
	public List<SubCorridor> getSubCorridors() {
		return subCorridors;
	}
	public void setSubCorridors(List<SubCorridor> subCorridors) {
		this.subCorridors = subCorridors;
	}
	
	
}
