package com.gmail.gstewart05.deviceservice.common.service.change.impl;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractDeviceChange;
import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDevice;
import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDeviceChangeService;
import com.gmail.gstewart05.dto.DTO;
import com.gmail.gstewart05.service.impl.AbstractServiceImpl;
import com.google.common.collect.Lists;

import java.util.List;

@SuppressWarnings( "unchecked" )
public abstract class AbstractDeviceChangeServiceImpl< T extends AbstractDevice, S extends DTO, R extends AbstractDeviceChange< T > > extends AbstractServiceImpl< R > implements AbstractDeviceChangeService< T, S, R >
{
	public abstract AbstractDeviceChangeRepository< T, R > getRepository();

	@Override
	public List< R > getByDevice( T pDevice )
	{
		return Lists.newArrayList( getRepository().findByDevice( pDevice ) );
	}
}
