package com.gmail.gstewart05.deviceservice.common.service.devices;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDoubleActuator;
import com.gmail.gstewart05.dto.DoubleDTO;

public interface AbstractDoubleActuatorService< T extends AbstractDoubleActuator, S extends DoubleDTO > extends AbstractDoubleDeviceService< T, S >
{
	void handleChangeRequest( S pDTO );
}
