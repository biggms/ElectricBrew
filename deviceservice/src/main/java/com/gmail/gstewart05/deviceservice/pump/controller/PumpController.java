package com.gmail.gstewart05.deviceservice.pump.controller;

import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.pump.model.devices.Pump;
import com.gmail.gstewart05.deviceservice.pump.service.PumpService;
import com.gmail.gstewart05.dto.PumpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
