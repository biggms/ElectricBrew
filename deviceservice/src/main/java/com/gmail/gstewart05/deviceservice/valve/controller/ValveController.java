package com.gmail.gstewart05.deviceservice.valve.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.deviceservice.valve.model.devices.Valve;
import com.gmail.gstewart05.deviceservice.valve.service.ValveService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.ValveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/valve/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class ValveController extends AbstractDeviceController< Valve, ValveDTO >
{
	@Autowired
	ValveService theValveService;

	@Override
	public ValveService getService()
	{
		return theValveService;
	}

	@Override
	public String getSimpleName()
	{
		return Valve.class.getSimpleName();
	}
}
