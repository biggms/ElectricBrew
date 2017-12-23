package com.gmail.gstewart05.deviceservice.bubbler.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractBooleanDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.bubbler.model.change.BubblerChange;
import com.gmail.gstewart05.deviceservice.bubbler.model.devices.Bubbler;
import com.gmail.gstewart05.deviceservice.bubbler.model.repo.BubblerChangeRepository;
import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerChangeService;
import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerService;
import com.gmail.gstewart05.dto.BubblerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BubblerChangeServiceImpl extends AbstractBooleanDeviceChangeServiceImpl< Bubbler, BubblerDTO, BubblerChange > implements BubblerChangeService
{
	@Autowired
	BubblerChangeRepository theRepository;

	@Autowired
	BubblerService theBubblerService;

	@Override
	public BubblerChangeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public BubblerChange getNew()
	{
		return new BubblerChange();
	}

	@Override
	public BubblerService getDeviceService()
	{
		return theBubblerService;
	}

	@Override
	public String getSimpleName()
	{
		return BubblerChange.class.getSimpleName();
	}
}
