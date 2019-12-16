package com.sahaj.soft.hotel_automation;

import com.sahaj.soft.hotel_automation.commands.Commands;
import com.sahaj.soft.hotel_automation.model.Electronics;
import com.sahaj.soft.hotel_automation.model.Floor;

public interface HotelSensorController {

	void verifySensorDataAndUpdateOperationOnDevice(Floor floor,Electronics light,Commands command);
}
