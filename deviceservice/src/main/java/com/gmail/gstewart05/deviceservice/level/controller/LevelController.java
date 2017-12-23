package com.gmail.gstewart05.deviceservice.level.controller;

import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.level.model.devices.Level;
import com.gmail.gstewart05.deviceservice.level.service.LevelService;
import com.gmail.gstewart05.dto.LevelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/level/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class LevelController extends AbstractDeviceController< Level, LevelDTO >
{
	@Autowired
	LevelService theLevelService;

	@Override
	public LevelService getService()
	{
		return theLevelService;
	}

	@Override
	public String getSimpleName()
	{
		return Level.class.getSimpleName();
	}
}
