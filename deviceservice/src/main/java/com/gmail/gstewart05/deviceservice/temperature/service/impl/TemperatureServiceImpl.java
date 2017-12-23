package com.gmail.gstewart05.deviceservice.temperature.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractDoubleDeviceServiceImpl;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.Temperature;
import com.gmail.gstewart05.deviceservice.temperature.model.repo.TemperatureRepository;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.dto.TemperatureDTO;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureServiceImpl extends AbstractDoubleDeviceServiceImpl< Temperature, TemperatureDTO > implements TemperatureService
{
	@Autowired
	TemperatureRepository theRepository;
	@Autowired
	private LogUtil theLogUtil;
	@Autowired
	private DTOFactory theDTOFactory;

	@Override
	public TemperatureRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public DoubleDTO getDTO()
	{
		return theDTOFactory.getTemperatureDTO();
	}

	@Override
	public String getSimpleName()
	{
		return Temperature.class.getSimpleName();
	}

	@Override
	public Temperature getByMac( String pMac )
	{
		return theRepository.findByMacIgnoreCase( pMac );
	}
}
