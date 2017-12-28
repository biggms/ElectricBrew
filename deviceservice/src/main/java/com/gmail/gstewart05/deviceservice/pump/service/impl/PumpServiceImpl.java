package com.gmail.gstewart05.deviceservice.pump.service.impl;

import com.gmail.gstewart05.deviceservice.pump.model.Pump;
import com.gmail.gstewart05.deviceservice.pump.model.repo.PumpRepository;
import com.gmail.gstewart05.deviceservice.pump.service.PumpService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.PumpDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.impl.NamedServiceImpl;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PumpServiceImpl extends NamedServiceImpl< Pump > implements PumpService
{
	@Autowired
	PumpRepository theRepository;

	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	LogUtil theLogUtil;

	@Override
	public PumpRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public String getSimpleName()
	{
		return Pump.class.getSimpleName();
	}

	@Override
	public NamedService< Pump > getService()
	{
		return this;
	}

	@Override
	public LogUtil getLogUtil()
	{
		return theLogUtil;
	}

	@Override
	public PumpDTO getDTO()
	{
		return theDTOFactory.getPumpDTO();
	}
}