package com.gmail.gstewart05.deviceservice.heater.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.gstewart05.controller.NamedController;
import com.gmail.gstewart05.deviceservice.heater.model.Heater;
import com.gmail.gstewart05.deviceservice.heater.service.HeaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/heater/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class HeaterController extends NamedController< Heater >
{
	@Autowired
	HeaterService theHeaterService;

	@Override
	public HeaterService getService()
	{
		return theHeaterService;
	}
}
