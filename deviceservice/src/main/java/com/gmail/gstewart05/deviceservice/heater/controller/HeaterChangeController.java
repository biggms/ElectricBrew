package com.gmail.gstewart05.deviceservice.heater.controller;

import com.gmail.gstewart05.controller.NamedChangeController;
import com.gmail.gstewart05.deviceservice.heater.model.Heater;
import com.gmail.gstewart05.deviceservice.heater.service.HeaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/heaterchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class HeaterChangeController extends NamedChangeController< Heater >
{
	@Autowired
	HeaterService theHeaterService;

	@Override
	public HeaterService getService()
	{
		return theHeaterService;
	}

}
