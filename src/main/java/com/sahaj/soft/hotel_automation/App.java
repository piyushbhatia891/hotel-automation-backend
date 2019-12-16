package com.sahaj.soft.hotel_automation;

import java.util.Arrays;
import java.util.Timer;

import com.sahaj.soft.hotel_automation.commands.Commands;
import com.sahaj.soft.hotel_automation.model.AirConditioner;
import com.sahaj.soft.hotel_automation.model.Floor;
import com.sahaj.soft.hotel_automation.model.Hotel;
import com.sahaj.soft.hotel_automation.model.Light;
import com.sahaj.soft.hotel_automation.model.MainCorridor;
import com.sahaj.soft.hotel_automation.model.SubCorridor;
import com.sahaj.soft.hotel_automation.scheduler.ScheduledTask;

public class App 
{
    public static void main( String[] args )
    {
    	HotelSensorController controller=new HotelSensorControllerImpl();
    	AirConditioner mainCorridorAirconditioner=new AirConditioner(1);
    	Light mainCorridorLight=new Light(1);
    	
    	AirConditioner subCorridorAirconditioner=new AirConditioner(1);
    	Light subCorridorLight=new Light(1);
    	
    	MainCorridor mainCorridor=new MainCorridor(1,Arrays.asList(mainCorridorAirconditioner)
    			,Arrays.asList(mainCorridorLight));
    	
    	SubCorridor subCorridor=new SubCorridor(1,Arrays.asList(subCorridorAirconditioner)
    			,Arrays.asList(subCorridorLight));
    	Floor floor=new Floor.FloorBuilder(1)
    			.mainCorridors(Arrays.asList(mainCorridor))
    			.subCorridors(Arrays.asList(subCorridor)).build();
    	int totalBill=Arrays.asList(floor).stream()
    			.mapToInt(floorVal->floorVal.getMaximumBill())
    			.sum();
    	Hotel hotel=new Hotel.HotelBuilder(1)
    			.floors(Arrays.asList(floor))
    			.totalBill(totalBill)
    			.build();
    	Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, 1000); // Create Repetitively task for every 1 secs

		//for demo only.
		for (int i = 0; i <= 5; i++) {
			System.out.println("Execution in Main Thread...." + i);
			if (i == 5) {
				System.out.println("Application Terminates");
				System.exit(0);
			}
		}
    	controller.verifySensorDataAndUpdateOperationOnDevice(floor,subCorridorLight,Commands.SWICTH_ON);
    }
}
