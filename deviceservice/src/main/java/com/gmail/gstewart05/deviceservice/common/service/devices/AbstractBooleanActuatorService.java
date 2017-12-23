package com.gmail.gstewart05.deviceservice.common.service.devices;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanActuator;
import com.gmail.gstewart05.dto.BooleanDTO;

public interface AbstractBooleanActuatorService< T extends AbstractBooleanActuator, S extends BooleanDTO > extends AbstractBooleanDeviceService< T, S >
{
	void handleChangeRequest( S pDTO );
}
