package com.gmail.gstewart05.deviceservice.pump.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractBooleanDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractBooleanDeviceService;
import com.gmail.gstewart05.deviceservice.pump.service.PumpChangeService;
import com.gmail.gstewart05.deviceservice.pump.service.PumpService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.PumpDTO;
import com.gmail.gstewart05.deviceservice.pump.model.devices.Pump;
import com.gmail.gstewart05.deviceservice.pump.model.change.PumpChange;
import com.gmail.gstewart05.deviceservice.pump.model.repo.PumpChangeRepository;
import com.gmail.gstewart05.utils.LogUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PumpChangeServiceImpl extends AbstractBooleanDeviceChangeServiceImpl< Pump, PumpDTO, PumpChange > implements PumpChangeService
{
	@Autowired
	PumpChangeRepository theRepository;

	@Autowired
	PumpService thePumpService;

	@Override
	public PumpChangeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public PumpChange getNew()
	{
		return new PumpChange();
	}

	@Override
	public PumpService getDeviceService()
	{
		return thePumpService;
	}

	@Override
	public String getSimpleName()
	{
		return PumpChange.class.getSimpleName();
	}
}
