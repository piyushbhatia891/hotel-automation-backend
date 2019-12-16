package com.sahaj.soft.hotel_automation.model;

import java.util.List;

public class Floor {

	public final int maximumBill;
	public final int floorId;
	public final List<MainCorridor> mainCorridors;
	public final List<SubCorridor> subCorridors;
	
	public Floor(FloorBuilder floorBuilder){
		this.maximumBill=floorBuilder.maximumBill;
		this.floorId=floorBuilder.floorId;
		this.mainCorridors=floorBuilder.mainCorridors;
		this.subCorridors=floorBuilder.subCorridors;
	}
	public static class FloorBuilder{
		private final int floorId;
		private int maximumBill;
		private List<MainCorridor> mainCorridors;
		private List<SubCorridor> subCorridors;
		
		public FloorBuilder(int floorId){
			this.floorId=floorId;
		}
		
		public FloorBuilder maximumBill(int maximumBill){
			this.maximumBill=maximumBill;
			return this;
		}
		
		public FloorBuilder mainCorridors(List<MainCorridor> mainCorridors){
			this.mainCorridors=mainCorridors;
			return this;
		}
		
		public FloorBuilder subCorridors(List<SubCorridor> subCorridors){
			this.subCorridors=subCorridors;
			return this;
		}
		
		public Floor build(){
			Floor floor=new Floor(this);
			return floor;
		}
		
	}
	
	
	public int getFloorId() {
		return floorId;
	}
	public int getMaximumBill() {
		return maximumBill;
	}
	public List<MainCorridor> getMainCorridors() {
		return mainCorridors;
	}
	public List<SubCorridor> getSubCorridors() {
		return subCorridors;
	}
}
