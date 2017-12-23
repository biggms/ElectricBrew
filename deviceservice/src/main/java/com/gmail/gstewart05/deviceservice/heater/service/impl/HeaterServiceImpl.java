package com.gmail.gstewart05.deviceservice.heater.service.impl;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractBooleanActuatorServiceImpl;
import com.gmail.gstewart05.deviceservice.heater.service.HeaterService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.HeaterDTO;
import com.gmail.gstewart05.deviceservice.heater.model.devices.Heater;
import com.gmail.gstewart05.deviceservice.heater.model.repo.HeaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeaterServiceImpl extends AbstractBooleanActuatorServiceImpl< Heater, HeaterDTO > implements HeaterService
{
	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	HeaterRepository theRepository;

	@Override
	public BooleanDTO getDTO()
	{
		return theDTOFactory.getHeaterDTO();
	}

	@Override
	public String getSimpleName()
	{
		return Heater.class.getSimpleName();
	}

	@Override
	public AbstractDeviceRepository< Heater > getRepository()
	{
		return theRepository;
	}
}
