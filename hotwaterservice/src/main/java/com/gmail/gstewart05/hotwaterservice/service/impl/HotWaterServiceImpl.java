package com.gmail.gstewart05.hotwaterservice.service.impl;

import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.HotWaterDTO;
import com.gmail.gstewart05.hotwaterservice.model.HotWater;
import com.gmail.gstewart05.hotwaterservice.model.repo.HotWaterRepository;
import com.gmail.gstewart05.hotwaterservice.service.HotWaterService;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.impl.NamedServiceImpl;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HotWaterServiceImpl extends NamedServiceImpl< HotWater > implements HotWaterService
{
	@Autowired
	HotWaterRepository theRepository;

	@Autowired
	DTOFactory theDTOFactory;

	@Autowired
	LogUtil theLogUtil;

	@Override
	public HotWaterRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public String getSimpleName()
	{
		return HotWater.class.getSimpleName();
	}

	@Override
	public NamedService< HotWater > getService()
	{
		return this;
	}

	@Override
	public LogUtil getLogUtil()
	{
		return theLogUtil;
	}

	@Override
	public HotWaterDTO getDTO()
	{
		return theDTOFactory.getHotWaterDTO();
	}
}