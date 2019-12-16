package com.sahaj.soft.hotel_automation.model;

import java.util.List;

public class Hotel {

	public final int hotelId;
	public final List<Floor> floors;
	public final int totalBill;

	public int getHotelId() {
		return hotelId;
	}
	
	public List<Floor> getFloors() {
		return floors;
	}
	
	public int getTotalBill() {
		return totalBill;
	}
	public Hotel(HotelBuilder hotelBuilder){
		this.floors=hotelBuilder.floors;
		this.hotelId=hotelBuilder.hotelId;
		this.totalBill=hotelBuilder.totalBill;
	}
	
	public static class HotelBuilder{
		private final int hotelId;
		private List<Floor> floors;
		private int totalBill;
		
		public HotelBuilder(int hotelId){
			this.hotelId=hotelId;
		}
		
		public HotelBuilder floors(List<Floor> floors){
			this.floors=floors;
			return this;
		}
		
		public HotelBuilder totalBill(int totalBill){
			this.totalBill=totalBill;
			return this;
		}
		
		public Hotel build(){
			Hotel hotel =  new Hotel(this);
            return hotel;
		}
	}
	
	
}
