package com.gmail.gstewart05.deviceservice.pump.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.gstewart05.controller.NamedController;
import com.gmail.gstewart05.deviceservice.pump.model.Pump;
import com.gmail.gstewart05.deviceservice.pump.service.PumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/pump/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class PumpController extends NamedController< Pump >
{
	@Autowired
	PumpService thePumpService;

	@Override
	public PumpService getService()
	{
		return thePumpService;
	}
}
