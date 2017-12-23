package com.gmail.gstewart05.deviceservice.cooler.service.impl;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractBooleanActuatorServiceImpl;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.CoolerDTO;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import com.gmail.gstewart05.deviceservice.cooler.model.repo.CoolerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoolerServiceImpl extends AbstractBooleanActuatorServiceImpl< Cooler, CoolerDTO > implements CoolerService
{
	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	CoolerRepository theRepository;

	@Override
	public BooleanDTO getDTO()
	{
		return theDTOFactory.getCoolerDTO();
	}

	@Override
	public String getSimpleName()
	{
		return Cooler.class.getSimpleName();
	}

	@Override
	public AbstractDeviceRepository< Cooler > getRepository()
	{
		return theRepository;
	}
}
