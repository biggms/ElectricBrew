package com.gmail.gstewart05.deviceservice.pump.service.impl;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractBooleanActuatorServiceImpl;
import com.gmail.gstewart05.deviceservice.pump.service.PumpService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.PumpDTO;
import com.gmail.gstewart05.deviceservice.pump.model.devices.Pump;
import com.gmail.gstewart05.deviceservice.pump.model.repo.PumpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PumpServiceImpl extends AbstractBooleanActuatorServiceImpl< Pump, PumpDTO > implements PumpService
{
	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	PumpRepository theRepository;

	@Override
	public BooleanDTO getDTO()
	{
		return theDTOFactory.getPumpDTO();
	}

	@Override
	public String getSimpleName()
	{
		return Pump.class.getSimpleName();
	}

	@Override
	public AbstractDeviceRepository< Pump > getRepository()
	{
		return theRepository;
	}
}
