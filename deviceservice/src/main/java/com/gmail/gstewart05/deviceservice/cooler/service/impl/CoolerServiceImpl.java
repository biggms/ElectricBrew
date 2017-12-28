package com.gmail.gstewart05.deviceservice.cooler.service.impl;

import com.gmail.gstewart05.deviceservice.cooler.model.Cooler;
import com.gmail.gstewart05.deviceservice.cooler.model.repo.CoolerRepository;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.CoolerDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.impl.NamedServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoolerServiceImpl extends NamedServiceImpl< Cooler > implements CoolerService
{
	@Autowired
	CoolerRepository theRepository;

	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	LogUtil theLogUtil;

	@Override
	public CoolerRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public String getSimpleName()
	{
		return Cooler.class.getSimpleName();
	}

	@Override
	public NamedService< Cooler > getService()
	{
		return this;
	}

	@Override
	public LogUtil getLogUtil()
	{
		return theLogUtil;
	}

	@Override
	public CoolerDTO getDTO()
	{
		return theDTOFactory.getCoolerDTO();
	}
}