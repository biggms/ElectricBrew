package com.gmail.gstewart05.deviceservice.level.service.impl;

import com.gmail.gstewart05.deviceservice.level.model.Level;
import com.gmail.gstewart05.deviceservice.level.model.repo.LevelRepository;
import com.gmail.gstewart05.deviceservice.level.service.LevelService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.LevelDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.impl.NamedServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelServiceImpl extends NamedServiceImpl< Level > implements LevelService
{
	@Autowired
	LevelRepository theRepository;

	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	LogUtil theLogUtil;

	@Override
	public LevelRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public String getSimpleName()
	{
		return Level.class.getSimpleName();
	}

	@Override
	public NamedService< Level > getService()
	{
		return this;
	}

	@Override
	public LogUtil getLogUtil()
	{
		return theLogUtil;
	}

	@Override
	public LevelDTO getDTO()
	{
		return theDTOFactory.getLevelDTO();
	}
}