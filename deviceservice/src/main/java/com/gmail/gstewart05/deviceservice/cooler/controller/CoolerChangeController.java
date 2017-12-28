package com.gmail.gstewart05.deviceservice.cooler.controller;

import com.gmail.gstewart05.controller.NamedChangeController;
import com.gmail.gstewart05.deviceservice.cooler.model.Cooler;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/coolerchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class CoolerChangeController extends NamedChangeController< Cooler >
{
	@Autowired
	CoolerService theCoolerService;

	@Override
	public CoolerService getService()
	{
		return theCoolerService;
	}

}
