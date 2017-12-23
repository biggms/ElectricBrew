package com.gmail.gstewart05.deviceservice.temperature.service.impl;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractDoubleDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.temperature.model.change.TemperatureChange;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureProbeService;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureChangeService;
import com.gmail.gstewart05.dto.TemperatureDTO;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;
import com.gmail.gstewart05.deviceservice.temperature.model.repo.TemperatureChangeRepository;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TemperatureChangeServiceImpl extends AbstractDoubleDeviceChangeServiceImpl< TemperatureProbe, TemperatureDTO, TemperatureChange > implements TemperatureChangeService
{
	@Autowired
	TemperatureChangeRepository theRepository;

	@Autowired
	TemperatureProbeService theTemperatureProbeService;

	@Autowired
	private LogUtil theLogUtil;

	@Override
	public TemperatureChange getNew()
	{
		return new TemperatureChange();
	}

	@Override
	public TemperatureProbeService getDeviceService()
	{
		return theTemperatureProbeService;
	}

	@Override
	public String getSimpleName()
	{
		return TemperatureChange.class.getSimpleName();
	}

	@Override
	public AbstractDeviceChangeRepository< TemperatureProbe, TemperatureChange > getRepository()
	{
		return theRepository;
	}

	@Override
	public void handleNewChange( TemperatureDTO pDTO )
	{
		TemperatureProbe lProbe = theTemperatureProbeService.getByMac( pDTO.getMac() );

		if( lProbe == null )
		{
			theLogUtil.warn( "Unknown {0}: Mac: {1}", getSimpleName(), pDTO.getMac() );
			return;
		}

		pDTO.setName( lProbe.getName() );
		super.handleNewChange( pDTO );
	}
}
