package com.gmail.gstewart05.hotwaterservice.controller;

import com.gmail.gstewart05.controller.NamedChangeController;
import com.gmail.gstewart05.hotwaterservice.model.HotWater;
import com.gmail.gstewart05.hotwaterservice.service.HotWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/hotWaterchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class HotWaterChangeController extends NamedChangeController< HotWater >
{
	@Autowired
	HotWaterService theHotWaterService;

	@Override
	public HotWaterService getService()
	{
		return theHotWaterService;
	}

}
