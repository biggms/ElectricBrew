package com.gmail.gstewart05.deviceservice.level.controller;

import com.gmail.gstewart05.controller.NamedChangeController;
import com.gmail.gstewart05.deviceservice.level.model.Level;
import com.gmail.gstewart05.deviceservice.level.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/levelchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class LevelChangeController extends NamedChangeController< Level >
{
	@Autowired
	LevelService theLevelService;

	@Override
	public LevelService getService()
	{
		return theLevelService;
	}

}
