package com.gmail.gstewart05.deviceservice.valve.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDeviceChangeService;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.deviceservice.valve.model.devices.Valve;
import com.gmail.gstewart05.deviceservice.valve.model.change.ValveChange;
import com.gmail.gstewart05.deviceservice.valve.service.ValveChangeService;
import com.gmail.gstewart05.deviceservice.valve.service.ValveService;
import com.gmail.gstewart05.dto.ValveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/valvechange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class ValveChangeController extends AbstractDeviceChangeController< Valve, ValveDTO, ValveChange >
{
	@Autowired
	ValveChangeService theValveChangeService;

	@Autowired
	ValveService theValveService;

	@Override
	public ValveChangeService getChangeService()
	{
		return theValveChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return ValveChange.class.getSimpleName();
	}

	@Override
	public ValveService getDeviceService()
	{
		return theValveService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return Valve.class.getSimpleName();
	}
}
