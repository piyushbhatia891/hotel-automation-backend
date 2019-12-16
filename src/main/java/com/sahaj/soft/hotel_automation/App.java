package com.sahaj.soft.hotel_automation;

import java.util.Arrays;
import com.sahaj.soft.hotel_automation.commands.Commands;
import com.sahaj.soft.hotel_automation.model.AirConditioner;
import com.sahaj.soft.hotel_automation.model.Floor;
import com.sahaj.soft.hotel_automation.model.Hotel;
import com.sahaj.soft.hotel_automation.model.Light;
import com.sahaj.soft.hotel_automation.model.MainCorridor;
import com.sahaj.soft.hotel_automation.model.SubCorridor;

public class App 
{
	HotelSensorController controller;
	AirConditioner mainCorridorAirconditioner,subCorridorAirconditioner;
	Light mainCorridorLight,subCorridorLight;
	MainCorridor mainCorridor;
	SubCorridor subCorridor;
	Floor floor;
	Hotel hotel;
	int totalBill;
	
    public static void main( String[] args )
    {
    	
    	//Main class For starting flow
    	App app =new App();
    	app.createDatasetAndIssueACommandFromSensor();
    	
    
    	/*
    	 * Executing timer for checking each minute movement
    	 * 
    	Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, 1000); // Create Repetitively task
		*/
    	
    }
    
    public void createDatasetAndIssueACommandFromSensor() {
    	controller=new HotelSensorControllerImpl();
    	mainCorridorAirconditioner=new AirConditioner(1);
    	mainCorridorLight=new Light(1);
    	
    	subCorridorAirconditioner=new AirConditioner(1);
    	subCorridorLight=new Light(1);
    	
    	mainCorridor=new MainCorridor(1,Arrays.asList(mainCorridorAirconditioner)
    			,Arrays.asList(mainCorridorLight));
    	
    	subCorridor=new SubCorridor(1,Arrays.asList(subCorridorAirconditioner)
    			,Arrays.asList(subCorridorLight));
    	floor=new Floor.FloorBuilder(1)
    			.mainCorridors(Arrays.asList(mainCorridor))
    			.subCorridors(Arrays.asList(subCorridor)).build();
    	totalBill=Arrays.asList(floor).stream()
    			.mapToInt(floorVal->floorVal.getMaximumBill())
    			.sum();
    	hotel=new Hotel.HotelBuilder(1)
    			.floors(Arrays.asList(floor))
    			.totalBill(totalBill)
    			.build();
    	
    	//Issuing a command to sensor controller
    	controller.verifySensorDataAndUpdateOperationOnDevice(floor,subCorridorLight,Commands.SWICTH_ON);
    }
}
