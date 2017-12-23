package com.gmail.gstewart05.deviceservice.bubbler.controller;

import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.bubbler.model.devices.Bubbler;
import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerService;
import com.gmail.gstewart05.dto.BubblerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/bubbler/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class BubblerController extends AbstractDeviceController< Bubbler, BubblerDTO >
{
	@Autowired
	BubblerService theBubblerService;

	@Override
	public BubblerService getService()
	{
		return theBubblerService;
	}

	@Override
	public String getSimpleName()
	{
		return Bubbler.class.getSimpleName();
	}
}
