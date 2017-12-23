package com.gmail.gstewart05.deviceservice.common.service.devices.impl;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDoubleDevice;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDoubleDeviceService;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public abstract class AbstractDoubleDeviceServiceImpl< T extends AbstractDoubleDevice, S extends DoubleDTO > extends AbstractDeviceServiceImpl< T, S > implements AbstractDoubleDeviceService< T, S >
{
	@Autowired
	LogUtil theLogUtil;

	public abstract DoubleDTO getDTO();

	public abstract String getSimpleName();

	@Override
	public T save( T pEntity )
	{
		if( pEntity.getId() != null )
		{
			getDTO().valueChanged( pEntity.getName(), pEntity.getCurrentValue() );
			theLogUtil.trace( "{0} - {1} Changed to: {2}", getSimpleName(), pEntity.getName(), pEntity.getCurrentValue() );
		}
		else
		{
			theLogUtil.info( "{0} created: {1}", getSimpleName(), pEntity.getName() );
		}
		return getRepository().save( pEntity );
	}
}
