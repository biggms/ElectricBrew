package com.gmail.gstewart05.deviceservice.level.service.impl;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractBooleanDeviceServiceImpl;
import com.gmail.gstewart05.deviceservice.level.model.devices.Level;
import com.gmail.gstewart05.deviceservice.level.model.repo.LevelRepository;
import com.gmail.gstewart05.deviceservice.level.service.LevelService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.LevelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelServiceImpl extends AbstractBooleanDeviceServiceImpl< Level, LevelDTO > implements LevelService
{
	@Autowired
	LevelRepository theRepository;
	@Autowired
	private DTOFactory theDTOFactory;

	@Override
	public BooleanDTO getDTO()
	{
		return theDTOFactory.getLevelDTO();
	}

	@Override
	public String getSimpleName()
	{
		return Level.class.getSimpleName();
	}

	@Override
	public AbstractDeviceRepository< Level > getRepository()
	{
		return theRepository;
	}
}
