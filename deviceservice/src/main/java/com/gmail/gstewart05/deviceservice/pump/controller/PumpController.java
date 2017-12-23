package com.gmail.gstewart05.deviceservice.pump.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.deviceservice.pump.model.devices.Pump;
import com.gmail.gstewart05.deviceservice.pump.service.PumpService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.PumpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/pump/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class PumpController extends AbstractDeviceController< Pump, PumpDTO >
{
	@Autowired
	PumpService thePumpService;

	@Override
	public PumpService getService()
	{
		return thePumpService;
	}

	@Override
	public String getSimpleName()
	{
		return Pump.class.getSimpleName();
	}
}
