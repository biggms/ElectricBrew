package com.gmail.gstewart05.deviceservice.common.service.devices;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDevice;
import com.gmail.gstewart05.dto.DTO;
import com.gmail.gstewart05.service.AbstractService;

public interface AbstractDeviceService< T extends AbstractDevice, S extends DTO > extends AbstractService< T >
{
	T getByName( String pName );
}
