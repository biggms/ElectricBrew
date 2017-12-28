package com.gmail.gstewart05.hotwaterservice.controller;

import com.gmail.gstewart05.controller.NamedController;
import com.gmail.gstewart05.hotwaterservice.model.HotWater;
import com.gmail.gstewart05.hotwaterservice.service.HotWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/hotwater/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class HotWaterController extends NamedController< HotWater >
{
	@Autowired
	HotWaterService theCoolerService;

	@Override
	public HotWaterService getService()
	{
		return theCoolerService;
	}
}
