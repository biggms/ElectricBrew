package com.gmail.gstewart05.deviceservice.pump.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDeviceChangeService;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.deviceservice.pump.model.devices.Pump;
import com.gmail.gstewart05.deviceservice.pump.model.change.PumpChange;
import com.gmail.gstewart05.deviceservice.pump.service.PumpChangeService;
import com.gmail.gstewart05.deviceservice.pump.service.PumpService;
import com.gmail.gstewart05.dto.PumpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/pumpchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class PumpChangeController extends AbstractDeviceChangeController< Pump, PumpDTO, PumpChange >
{
	@Autowired
	PumpChangeService thePumpChangeService;

	@Autowired
	PumpService thePumpService;

	@Override
	public PumpChangeService getChangeService()
	{
		return thePumpChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return PumpChange.class.getSimpleName();
	}

	@Override
	public PumpService getDeviceService()
	{
		return thePumpService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return Pump.class.getSimpleName();
	}
}
