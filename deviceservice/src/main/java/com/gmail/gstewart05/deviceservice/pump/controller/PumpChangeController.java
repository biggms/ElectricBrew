package com.gmail.gstewart05.deviceservice.pump.controller;

import com.gmail.gstewart05.controller.NamedChangeController;
import com.gmail.gstewart05.deviceservice.pump.model.Pump;
import com.gmail.gstewart05.deviceservice.pump.service.PumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/pumpchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class PumpChangeController extends NamedChangeController< Pump >
{
	@Autowired
	PumpService thePumpService;

	@Override
	public PumpService getService()
	{
		return thePumpService;
	}

}
