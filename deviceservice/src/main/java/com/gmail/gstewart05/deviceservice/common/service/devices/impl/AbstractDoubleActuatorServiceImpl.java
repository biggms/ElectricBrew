package com.gmail.gstewart05.deviceservice.common.service.devices.impl;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDoubleActuator;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDoubleActuatorService;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDoubleActuatorServiceImpl< T extends AbstractDoubleActuator, S extends DoubleDTO > extends AbstractDoubleDeviceServiceImpl< T, S > implements AbstractDoubleActuatorService< T, S >
{
	@Autowired
	LogUtil theLogUtil;

	public abstract DoubleDTO getDTO();

	public abstract String getSimpleName();

	@Override
	public void handleChangeRequest( S pDTO )
	{
		T lEntity = getByName( pDTO.getName() );
		if( lEntity == null )
		{
			theLogUtil.warn( "Unknown {0}: {1}", getSimpleName(), pDTO.getName() );
			return;
		}

		if( lEntity.getCurrentValue() != pDTO.getValue() )
		{
			lEntity.setRequestedValue( pDTO.getValue() );
			save( lEntity );
			theLogUtil.trace( "{0}: {1} Change Requested: {2}", getSimpleName(), pDTO.getName(), pDTO.getValue() );
		}
	}

	@Override
	public T save( T pEntity )
	{
		pEntity = super.save( pEntity );
		if( pEntity.getId() != null )
		{
			if( pEntity.getCurrentValue() != pEntity.getRequestedValue() )
			{
				theLogUtil.trace( "{0}: {1} is not requested value {2} vs {3}, changing", getSimpleName(), pEntity.getName(), pEntity.getCurrentValue(), pEntity.getRequestedValue() );
				getDTO().setValue( pEntity.getName(), pEntity.getRequestedValue() );
			}
		}
		return pEntity;
	}
}
