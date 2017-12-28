package com.gmail.gstewart05.deviceservice.temperature.service.impl;

import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import com.gmail.gstewart05.deviceservice.temperature.model.repo.TemperatureRepository;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.TemperatureDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.impl.NamedServiceImpl;
import com.gmail.gstewart05.service.wrappers.DoubleSensorServiceImpl;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureServiceImpl extends NamedServiceImpl< Temperature > implements TemperatureService
{
	@Autowired
	TemperatureRepository theRepository;

	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	LogUtil theLogUtil;

	@Override
	public TemperatureRepository getRepository()
	{
		return theRepository;
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

	@Override
	public NamedService< Temperature > getService()
	{
		return this;
	}

	@Override
	public LogUtil getLogUtil()
	{
		return theLogUtil;
	}

	@Override
	public TemperatureDTO getDTO()
	{
		return theDTOFactory.getTemperatureDTO();
	}

	@Override
	public void handleNewValueChange( TemperatureDTO pDTO )
	{
		Temperature lEntity = getByMac( pDTO.getMac() );

		if( lEntity == null )
		{
			theLogUtil.warn( "Unknown {0}: Mac: {1}", getSimpleName(), pDTO.getMac() );
			return;
		}

		pDTO.setName( lEntity.getName() );
		TemperatureService.super.handleNewValueChange( pDTO );
	}
}