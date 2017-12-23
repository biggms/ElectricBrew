package com.gmail.gstewart05.deviceservice.temperature.service;

import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDoubleDeviceService;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;
import com.gmail.gstewart05.dto.TemperatureDTO;

public interface TemperatureProbeService extends AbstractDoubleDeviceService< TemperatureProbe, TemperatureDTO >
{
	TemperatureProbe getByMac( String pMac );
}
