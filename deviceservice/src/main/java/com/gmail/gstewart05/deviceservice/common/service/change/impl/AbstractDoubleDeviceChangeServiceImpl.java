package com.gmail.gstewart05.deviceservice.common.service.change.impl;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractDoubleDeviceChange;
import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDoubleDevice;
import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDoubleDeviceChangeService;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDoubleDeviceService;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class AbstractDoubleDeviceChangeServiceImpl< T extends AbstractDoubleDevice, S extends DoubleDTO, R extends AbstractDoubleDeviceChange< T > > extends AbstractDeviceChangeServiceImpl< T, S, R > implements AbstractDoubleDeviceChangeService< T, S, R >
{
	@Autowired
	LogUtil theLogUtil;

	public abstract R getNew();
	public abstract AbstractDoubleDeviceService< T, S > getDeviceService();
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

		if( pDTO.getValue() == lEntity.getCurrentValue() )
		{
			return;
		}

		R lChange = getNew();
		lChange.setDevice( lEntity );
		lChange.setValue( pDTO.getValue() );
		getRepository().save( lChange );

		lEntity.setCurrentValue( pDTO.getValue() );
		getDeviceService().save( lEntity );
	}
}
