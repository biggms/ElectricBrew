package com.gmail.gstewart05.deviceservice.valve.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractBooleanDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.valve.model.change.ValveChange;
import com.gmail.gstewart05.deviceservice.valve.model.devices.Valve;
import com.gmail.gstewart05.deviceservice.valve.model.repo.ValveChangeRepository;
import com.gmail.gstewart05.deviceservice.valve.service.ValveChangeService;
import com.gmail.gstewart05.deviceservice.valve.service.ValveService;
import com.gmail.gstewart05.dto.ValveDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValveChangeServiceImpl extends AbstractBooleanDeviceChangeServiceImpl< Valve, ValveDTO, ValveChange > implements ValveChangeService
{
	@Autowired
	ValveChangeRepository theRepository;

	@Autowired
	ValveService theValveService;

	@Override
	public ValveChangeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public ValveChange getNew()
	{
		return new ValveChange();
	}

	@Override
	public ValveService getDeviceService()
	{
		return theValveService;
	}

	@Override
	public String getSimpleName()
	{
		return ValveChange.class.getSimpleName();
	}
}
