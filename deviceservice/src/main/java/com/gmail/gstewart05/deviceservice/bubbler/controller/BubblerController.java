package com.gmail.gstewart05.deviceservice.bubbler.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.gstewart05.controller.NamedController;
import com.gmail.gstewart05.deviceservice.bubbler.model.Bubbler;
import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/bubbler/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class BubblerController extends NamedController< Bubbler >
{
	@Autowired
	BubblerService theBubblerService;

	@Override
	public BubblerService getService()
	{
		return theBubblerService;
	}
}
