package com.gmail.gstewart05.deviceservice.common.service.devices.impl;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanDevice;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractBooleanDeviceService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBooleanDeviceServiceImpl< T extends AbstractBooleanDevice, S extends BooleanDTO > extends AbstractDeviceServiceImpl< T, S > implements AbstractBooleanDeviceService< T, S >
{
	@Autowired
	LogUtil theLogUtil;

	public abstract BooleanDTO getDTO();
	public abstract String getSimpleName();

	@Override
	public T save( T pEntity )
	{
		if( pEntity.getId() != null )
		{
			getDTO().stateChanged( pEntity.getName(), pEntity.isEnabled() );
			theLogUtil.trace( "{0} - {1} Changed to: {1}", getSimpleName(), pEntity.getName(), pEntity.isEnabled() );
		}
		else
		{
			theLogUtil.info( "{0} created: {1}", getSimpleName(), pEntity.getName() );
		}
		return getRepository().save( pEntity );
	}
}
