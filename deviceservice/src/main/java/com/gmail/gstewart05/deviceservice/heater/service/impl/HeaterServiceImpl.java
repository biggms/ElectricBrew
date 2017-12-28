package com.gmail.gstewart05.deviceservice.heater.service.impl;

import com.gmail.gstewart05.deviceservice.heater.model.Heater;
import com.gmail.gstewart05.deviceservice.heater.model.repo.HeaterRepository;
import com.gmail.gstewart05.deviceservice.heater.service.HeaterService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.HeaterDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.impl.NamedServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Service
@Slf4j
public class HeaterServiceImpl extends NamedServiceImpl< Heater > implements HeaterService
{
	@Autowired
	HeaterRepository theRepository;

	@Autowired
	DTOFactory theDTOFactory;

	@Autowired
	LogUtil theLogUtil;

	@Override
	public HeaterRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public String getSimpleName()
	{
		return Heater.class.getSimpleName();
	}

	@Override
	public NamedService< Heater > getService()
	{
		return this;
	}

	@Override
	public LogUtil getLogUtil()
	{
		return theLogUtil;
	}

	@Override
	public HeaterDTO getDTO()
	{
		return theDTOFactory.getHeaterDTO();
	}
}