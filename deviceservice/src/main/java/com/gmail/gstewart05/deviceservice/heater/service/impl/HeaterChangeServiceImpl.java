package com.gmail.gstewart05.deviceservice.heater.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractBooleanDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.heater.model.change.HeaterChange;
import com.gmail.gstewart05.deviceservice.heater.model.devices.Heater;
import com.gmail.gstewart05.deviceservice.heater.model.repo.HeaterChangeRepository;
import com.gmail.gstewart05.deviceservice.heater.service.HeaterChangeService;
import com.gmail.gstewart05.deviceservice.heater.service.HeaterService;
import com.gmail.gstewart05.dto.HeaterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HeaterChangeServiceImpl extends AbstractBooleanDeviceChangeServiceImpl< Heater, HeaterDTO, HeaterChange > implements HeaterChangeService
{
	@Autowired
	HeaterChangeRepository theRepository;

	@Autowired
	HeaterService theHeaterService;

	@Override
	public HeaterChangeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public HeaterChange getNew()
	{
		return new HeaterChange();
	}

	@Override
	public HeaterService getDeviceService()
	{
		return theHeaterService;
	}

	@Override
	public String getSimpleName()
	{
		return HeaterChange.class.getSimpleName();
	}
}
