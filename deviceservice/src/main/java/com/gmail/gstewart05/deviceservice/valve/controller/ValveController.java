package com.gmail.gstewart05.deviceservice.valve.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.gstewart05.controller.NamedController;
import com.gmail.gstewart05.deviceservice.valve.model.Valve;
import com.gmail.gstewart05.deviceservice.valve.service.ValveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/valve/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class ValveController extends NamedController< Valve >
{
	@Autowired
	ValveService theValveService;

	@Override
	public ValveService getService()
	{
		return theValveService;
	}
}
