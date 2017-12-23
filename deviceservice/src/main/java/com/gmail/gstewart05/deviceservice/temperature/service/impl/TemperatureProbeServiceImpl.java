package com.gmail.gstewart05.deviceservice.temperature.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractDoubleDeviceServiceImpl;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureProbeService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;
import com.gmail.gstewart05.deviceservice.temperature.model.repo.TemperatureProbeRepository;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.dto.TemperatureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gmail.gstewart05.utils.LogUtil;

@Service
public class TemperatureProbeServiceImpl extends AbstractDoubleDeviceServiceImpl< TemperatureProbe, TemperatureDTO > implements TemperatureProbeService
{
	@Autowired
	private LogUtil theLogUtil;

	@Autowired
	TemperatureProbeRepository theRepository;

	@Autowired
	private DTOFactory theDTOFactory;

	@Override
	public TemperatureProbeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public DoubleDTO getDTO()
	{
		return theDTOFactory.getTemperatureProbeDTO();
	}

	@Override
	public String getSimpleName()
	{
		return TemperatureProbe.class.getSimpleName();
	}

	@Override
	public TemperatureProbe getByMac( String pMac )
	{
		return theRepository.findByMacIgnoreCase( pMac );
	}
}
