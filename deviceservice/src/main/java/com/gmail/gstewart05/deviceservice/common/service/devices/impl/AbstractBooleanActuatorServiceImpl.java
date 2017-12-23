package com.gmail.gstewart05.deviceservice.common.service.devices.impl;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanActuator;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractBooleanActuatorService;
import com.gmail.gstewart05.dto.BooleanDTO;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractBooleanActuatorServiceImpl< T extends AbstractBooleanActuator, S extends BooleanDTO > extends AbstractBooleanDeviceServiceImpl< T, S > implements AbstractBooleanActuatorService< T, S >
{
	@Override
	public void handleChangeRequest( S pDTO )
	{
		T lEntity = getByName( pDTO.getName() );
		if( lEntity == null )
		{
			theLogUtil.warn( "Unknown {0}: {1}", getSimpleName(), pDTO.getName() );
			return;
		}

		if( lEntity.isEnabled() != lEntity.isEnableRequested() )
		{
			theLogUtil.trace( "{0}: {1} Change Requested: {2}", getSimpleName(), pDTO.getName(), pDTO.isEnabled() );
			lEntity.setEnableRequested( pDTO.isEnabled() );
			save( lEntity );
		}
	}

	@Override
	public T save( T pEntity )
	{
		pEntity = super.save( pEntity );
		if( pEntity.getId() != null )
		{
			if( pEntity.isEnabled() != pEntity.isEnableRequested() )
			{
				theLogUtil.trace( "{0}: {1} is not in requested state, changing", getSimpleName(), pEntity.getName() );
				getDTO().setState( pEntity.getName(), pEntity.isEnableRequested() );
			}
		}
		return pEntity;
	}
}
