package com.gmail.gstewart05.deviceservice.level.controller;

import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.level.model.change.LevelChange;
import com.gmail.gstewart05.deviceservice.level.model.devices.Level;
import com.gmail.gstewart05.deviceservice.level.service.LevelChangeService;
import com.gmail.gstewart05.deviceservice.level.service.LevelService;
import com.gmail.gstewart05.dto.LevelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/levelchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class LevelChangeController extends AbstractDeviceChangeController< Level, LevelDTO, LevelChange >
{
	@Autowired
	LevelChangeService theLevelChangeService;

	@Autowired
	LevelService theLevelService;

	@Override
	public LevelChangeService getChangeService()
	{
		return theLevelChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return LevelChange.class.getSimpleName();
	}

	@Override
	public LevelService getDeviceService()
	{
		return theLevelService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return Level.class.getSimpleName();
	}
}
