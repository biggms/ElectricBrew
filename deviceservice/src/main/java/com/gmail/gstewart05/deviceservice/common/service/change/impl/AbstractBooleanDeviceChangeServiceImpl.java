package com.gmail.gstewart05.deviceservice.common.service.change.impl;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractBooleanDeviceChange;
import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanDevice;
import com.gmail.gstewart05.deviceservice.common.service.change.AbstractBooleanDeviceChangeService;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractBooleanDeviceService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractBooleanDeviceChangeServiceImpl< T extends AbstractBooleanDevice, S extends BooleanDTO, R extends AbstractBooleanDeviceChange< T > > extends AbstractDeviceChangeServiceImpl< T, S, R > implements AbstractBooleanDeviceChangeService< T, S, R >
{
	@Autowired
	LogUtil theLogUtil;

	public abstract R getNew();

	public abstract AbstractBooleanDeviceService< T, S > getDeviceService();

	public abstract String getSimpleName();

	@Override
	public void handleNewChange( S pDTO )
	{
		T lEntity = getDeviceService().getByName( pDTO.getName() );
		if( lEntity == null )
		{
			theLogUtil.warn( "Unknown {0}: {1}", getSimpleName(), pDTO.getName() );
			return;
		}

		if( pDTO.isEnabled() == lEntity.isEnabled() )
		{
			return;
		}

		R lChange = getNew();
		lChange.setDevice( lEntity );
		lChange.setEnabled( pDTO.isEnabled() );
		getRepository().save( lChange );

		lEntity.setEnabled( pDTO.isEnabled() );
		getDeviceService().save( lEntity );
	}
}
