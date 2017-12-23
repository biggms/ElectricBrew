package com.gmail.gstewart05.deviceservice.temperature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.temperature.model.change.TemperatureChange;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.Temperature;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureChangeService;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureService;
import com.gmail.gstewart05.dto.TemperatureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/temperaturechange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class TemperatureChangeController extends AbstractDeviceChangeController< Temperature, TemperatureDTO, TemperatureChange >
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	TemperatureChangeService theTemperatureChangeService;

	@Autowired
	TemperatureService theTemperatureService;

	@Override
	public TemperatureChangeService getChangeService()
	{
		return theTemperatureChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return TemperatureChange.class.getSimpleName();
	}

	@Override
	public TemperatureService getDeviceService()
	{
		return theTemperatureService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return Temperature.class.getSimpleName();
	}
}
