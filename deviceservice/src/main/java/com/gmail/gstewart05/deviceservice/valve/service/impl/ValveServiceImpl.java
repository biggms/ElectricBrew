package com.gmail.gstewart05.deviceservice.valve.service.impl;

import com.gmail.gstewart05.deviceservice.valve.model.Valve;
import com.gmail.gstewart05.deviceservice.valve.model.repo.ValveRepository;
import com.gmail.gstewart05.deviceservice.valve.service.ValveService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.ValveDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.impl.NamedServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValveServiceImpl extends NamedServiceImpl< Valve > implements ValveService
{
	@Autowired
	ValveRepository theRepository;

	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	LogUtil theLogUtil;

	@Override
	public ValveRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public String getSimpleName()
	{
		return Valve.class.getSimpleName();
	}

	@Override
	public NamedService< Valve > getService()
	{
		return this;
	}

	@Override
	public LogUtil getLogUtil()
	{
		return theLogUtil;
	}

	@Override
	public ValveDTO getDTO()
	{
		return theDTOFactory.getValveDTO();
	}
}