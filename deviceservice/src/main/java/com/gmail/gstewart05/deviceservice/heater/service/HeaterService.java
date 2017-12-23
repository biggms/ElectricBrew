package com.gmail.gstewart05.deviceservice.heater.service;

import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractBooleanActuatorService;
import com.gmail.gstewart05.dto.HeaterDTO;
import com.gmail.gstewart05.deviceservice.heater.model.devices.Heater;

public interface HeaterService extends AbstractBooleanActuatorService< Heater, HeaterDTO >
{
	
}
