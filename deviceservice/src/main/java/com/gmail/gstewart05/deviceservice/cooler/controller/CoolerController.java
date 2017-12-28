package com.gmail.gstewart05.deviceservice.cooler.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.gstewart05.controller.NamedController;
import com.gmail.gstewart05.deviceservice.cooler.model.Cooler;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/cooler/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class CoolerController extends NamedController< Cooler >
{
	@Autowired
	CoolerService theCoolerService;

	@Override
	public CoolerService getService()
	{
		return theCoolerService;
	}
}
