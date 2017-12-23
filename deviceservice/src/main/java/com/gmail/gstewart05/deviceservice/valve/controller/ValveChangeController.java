package com.gmail.gstewart05.deviceservice.valve.controller;

import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.valve.model.change.ValveChange;
import com.gmail.gstewart05.deviceservice.valve.model.devices.Valve;
import com.gmail.gstewart05.deviceservice.valve.service.ValveChangeService;
import com.gmail.gstewart05.deviceservice.valve.service.ValveService;
import com.gmail.gstewart05.dto.ValveDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
