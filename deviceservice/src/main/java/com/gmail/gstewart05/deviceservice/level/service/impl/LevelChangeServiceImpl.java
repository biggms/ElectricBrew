package com.gmail.gstewart05.deviceservice.level.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractBooleanDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.level.model.change.LevelChange;
import com.gmail.gstewart05.deviceservice.level.model.devices.Level;
import com.gmail.gstewart05.deviceservice.level.model.repo.LevelChangeRepository;
import com.gmail.gstewart05.deviceservice.level.service.LevelChangeService;
import com.gmail.gstewart05.deviceservice.level.service.LevelService;
import com.gmail.gstewart05.dto.LevelDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LevelChangeServiceImpl extends AbstractBooleanDeviceChangeServiceImpl< Level, LevelDTO, LevelChange > implements LevelChangeService
{
	@Autowired
	LevelChangeRepository theRepository;

	@Autowired
	LevelService theLevelService;

	@Override
	public LevelChangeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public LevelChange getNew()
	{
		return new LevelChange();
	}

	@Override
	public LevelService getDeviceService()
	{
		return theLevelService;
	}

	@Override
	public String getSimpleName()
	{
		return LevelChange.class.getSimpleName();
	}
}
