package com.gmail.gstewart05.deviceservice.temperature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.controller.NamedChangeController;
import com.gmail.gstewart05.controller.NamedController;
import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/temperaturechange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class TemperatureChangeController extends NamedChangeController< Temperature >
{
	@Autowired
	TemperatureService theTemperatureService;

	@Override
	public TemperatureService getService()
	{
		return theTemperatureService;
	}

}
