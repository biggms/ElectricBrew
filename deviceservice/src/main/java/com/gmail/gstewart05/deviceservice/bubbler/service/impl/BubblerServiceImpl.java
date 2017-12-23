package com.gmail.gstewart05.deviceservice.bubbler.service.impl;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractBooleanDeviceServiceImpl;
import com.gmail.gstewart05.deviceservice.bubbler.model.devices.Bubbler;
import com.gmail.gstewart05.deviceservice.bubbler.model.repo.BubblerRepository;
import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.BubblerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BubblerServiceImpl extends AbstractBooleanDeviceServiceImpl< Bubbler, BubblerDTO > implements BubblerService
{
	@Autowired
	BubblerRepository theRepository;
	@Autowired
	private DTOFactory theDTOFactory;

	@Override
	public BooleanDTO getDTO()
	{
		return theDTOFactory.getBubblerDTO();
	}

	@Override
	public String getSimpleName()
	{
		return Bubbler.class.getSimpleName();
	}

	@Override
	public AbstractDeviceRepository< Bubbler > getRepository()
	{
		return theRepository;
	}
}
