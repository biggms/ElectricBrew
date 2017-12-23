package com.gmail.gstewart05.deviceservice.heatingelement.service;

import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractBooleanActuatorService;
import com.gmail.gstewart05.dto.HeatingElementDTO;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;

public interface HeatingElementService extends AbstractBooleanActuatorService< HeatingElement, HeatingElementDTO >
{
	
}
