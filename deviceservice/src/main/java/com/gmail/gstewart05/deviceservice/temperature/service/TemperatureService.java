package com.gmail.gstewart05.deviceservice.temperature.service;

import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDoubleDeviceService;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.Temperature;
import com.gmail.gstewart05.dto.TemperatureDTO;

public interface TemperatureService extends AbstractDoubleDeviceService< Temperature, TemperatureDTO >
{
	Temperature getByMac( String pMac );
}
