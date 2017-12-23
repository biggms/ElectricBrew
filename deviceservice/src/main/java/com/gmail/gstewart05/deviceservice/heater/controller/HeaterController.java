package com.gmail.gstewart05.deviceservice.heater.controller;

import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.heater.model.devices.Heater;
import com.gmail.gstewart05.deviceservice.heater.service.HeaterService;
import com.gmail.gstewart05.dto.HeaterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/heater/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class HeaterController extends AbstractDeviceController< Heater, HeaterDTO >
{
	@Autowired
	HeaterService theHeaterService;

	@Override
	public HeaterService getService()
	{
		return theHeaterService;
	}

	@Override
	public String getSimpleName()
	{
		return Heater.class.getSimpleName();
	}
}
