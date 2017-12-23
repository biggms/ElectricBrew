package com.gmail.gstewart05.deviceservice.heatingelement.service.impl;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractBooleanActuatorServiceImpl;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.HeatingElementDTO;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;
import com.gmail.gstewart05.deviceservice.heatingelement.model.repo.HeatingElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeatingElementServiceImpl extends AbstractBooleanActuatorServiceImpl< HeatingElement, HeatingElementDTO > implements HeatingElementService
{
	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	HeatingElementRepository theRepository;

	@Override
	public BooleanDTO getDTO()
	{
		return theDTOFactory.getHeatingElementDTO();
	}

	@Override
	public String getSimpleName()
	{
		return HeatingElement.class.getSimpleName();
	}

	@Override
	public AbstractDeviceRepository< HeatingElement > getRepository()
	{
		return theRepository;
	}
}
