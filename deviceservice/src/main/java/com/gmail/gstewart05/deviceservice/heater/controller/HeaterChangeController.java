package com.gmail.gstewart05.deviceservice.heater.controller;

import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.heater.model.devices.Heater;
import com.gmail.gstewart05.deviceservice.heater.model.change.HeaterChange;
import com.gmail.gstewart05.deviceservice.heater.service.HeaterChangeService;
import com.gmail.gstewart05.deviceservice.heater.service.HeaterService;
import com.gmail.gstewart05.dto.HeaterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/heaterchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class HeaterChangeController extends AbstractDeviceChangeController< Heater, HeaterDTO, HeaterChange >
{
	@Autowired
	HeaterChangeService theHeaterChangeService;

	@Autowired
	HeaterService theHeaterService;

	@Override
	public HeaterChangeService getChangeService()
	{
		return theHeaterChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return HeaterChange.class.getSimpleName();
	}

	@Override
	public HeaterService getDeviceService()
	{
		return theHeaterService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return Heater.class.getSimpleName();
	}
}
