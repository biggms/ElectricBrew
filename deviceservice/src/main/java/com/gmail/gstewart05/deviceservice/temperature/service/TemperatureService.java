package com.gmail.gstewart05.deviceservice.temperature.service;

import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import com.gmail.gstewart05.dto.TemperatureDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.wrappers.DoubleSensorServiceImpl;

public interface TemperatureService extends NamedService< Temperature >, DoubleSensorServiceImpl< Temperature, TemperatureDTO >
{
	Temperature getByMac( String pMac );
}
