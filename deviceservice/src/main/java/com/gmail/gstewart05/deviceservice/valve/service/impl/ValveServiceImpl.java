package com.gmail.gstewart05.deviceservice.valve.service.impl;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractBooleanActuatorServiceImpl;
import com.gmail.gstewart05.deviceservice.valve.model.devices.Valve;
import com.gmail.gstewart05.deviceservice.valve.model.repo.ValveRepository;
import com.gmail.gstewart05.deviceservice.valve.service.ValveService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.ValveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValveServiceImpl extends AbstractBooleanActuatorServiceImpl< Valve, ValveDTO > implements ValveService
{
	@Autowired
	ValveRepository theRepository;
	@Autowired
	private DTOFactory theDTOFactory;

	@Override
	public BooleanDTO getDTO()
	{
		return theDTOFactory.getValveDTO();
	}

	@Override
	public String getSimpleName()
	{
		return Valve.class.getSimpleName();
	}

	@Override
	public AbstractDeviceRepository< Valve > getRepository()
	{
		return theRepository;
	}
}
