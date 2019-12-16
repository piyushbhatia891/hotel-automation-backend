package com.sahaj.soft.hotel_automation;
import java.util.Arrays;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import com.sahaj.soft.hotel_automation.commands.Commands;
import com.sahaj.soft.hotel_automation.model.AirConditioner;
import com.sahaj.soft.hotel_automation.model.Floor;
import com.sahaj.soft.hotel_automation.model.Hotel;
import com.sahaj.soft.hotel_automation.model.Light;
import com.sahaj.soft.hotel_automation.model.MainCorridor;
import com.sahaj.soft.hotel_automation.model.SubCorridor;
import com.sahaj.soft.hotel_automation.states.DeviceState;
import com.sahaj.soft.hotel_automation.states.OnState;
public class HotelSensorControllerTest {

	HotelSensorController controller;
	AirConditioner mainCorridorAirconditioner;
	Light mainCorridorLight;
	AirConditioner subCorridorAirconditioner;
	Light subCorridorLight;
	MainCorridor mainCorridor;
	SubCorridor subCorridor;
	Floor floor;
	public HotelSensorControllerTest(){
		this.controller=new HotelSensorControllerImpl();
	}
	
	@Before
	public void setUp(){
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
    	int totalBill=Arrays.asList(floor).stream()
    			.mapToInt(floorVal->floorVal.getMaximumBill())
    			.sum();
    	Hotel hotel=new Hotel.HotelBuilder(1)
    			.floors(Arrays.asList(floor))
    			.totalBill(totalBill)
    			.build();
    	
	}
	
	@Test
	public void testSensorData(){
		controller.verifySensorDataAndUpdateOperationOnDevice(floor,subCorridorLight,Commands.SWICTH_ON);
		DeviceState state= subCorridorLight.deviceStatus.getDeviceState();
		DeviceState expected=OnState.instance();
		assertThat(state,is(expected));
	}
	
	@Test
	public void testSensorDataForSwitchingOnLightForDifferentCorridors(){
		controller.verifySensorDataAndUpdateOperationOnDevice(floor,subCorridorLight,Commands.SWICTH_ON);
		controller.verifySensorDataAndUpdateOperationOnDevice(floor,mainCorridorLight,Commands.SWICTH_ON);
		DeviceState state= mainCorridorLight.deviceStatus.getDeviceState();
		DeviceState expected=OnState.instance();
		assertThat(state,is(expected));
	}
}
