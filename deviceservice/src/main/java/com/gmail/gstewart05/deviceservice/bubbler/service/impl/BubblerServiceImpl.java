package com.gmail.gstewart05.deviceservice.bubbler.service.impl;

import com.gmail.gstewart05.deviceservice.bubbler.model.Bubbler;
import com.gmail.gstewart05.deviceservice.bubbler.model.repo.BubblerRepository;
import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.BubblerDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.impl.NamedServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BubblerServiceImpl extends NamedServiceImpl< Bubbler > implements BubblerService
{
	@Autowired
	BubblerRepository theRepository;

	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	LogUtil theLogUtil;

	@Override
	public BubblerRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public String getSimpleName()
	{
		return Bubbler.class.getSimpleName();
	}

	@Override
	public NamedService< Bubbler > getService()
	{
		return this;
	}

	@Override
	public LogUtil getLogUtil()
	{
		return theLogUtil;
	}

	@Override
	public BubblerDTO getDTO()
	{
		return theDTOFactory.getBubblerDTO();
	}
}