package com.gmail.gstewart05.deviceservice.cooler.service;

import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractBooleanActuatorService;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import com.gmail.gstewart05.dto.CoolerDTO;

public interface CoolerService extends AbstractBooleanActuatorService< Cooler, CoolerDTO >
{
	
}
