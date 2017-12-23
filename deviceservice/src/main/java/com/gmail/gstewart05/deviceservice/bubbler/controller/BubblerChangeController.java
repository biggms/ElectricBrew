package com.gmail.gstewart05.deviceservice.bubbler.controller;

import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.bubbler.model.change.BubblerChange;
import com.gmail.gstewart05.deviceservice.bubbler.model.devices.Bubbler;
import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerChangeService;
import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerService;
import com.gmail.gstewart05.dto.BubblerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/bubblerchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class BubblerChangeController extends AbstractDeviceChangeController< Bubbler, BubblerDTO, BubblerChange >
{
	@Autowired
	BubblerChangeService theBubblerChangeService;

	@Autowired
	BubblerService theBubblerService;

	@Override
	public BubblerChangeService getChangeService()
	{
		return theBubblerChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return BubblerChange.class.getSimpleName();
	}

	@Override
	public BubblerService getDeviceService()
	{
		return theBubblerService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return Bubbler.class.getSimpleName();
	}
}
