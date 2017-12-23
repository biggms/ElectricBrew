package com.gmail.gstewart05.deviceservice.common.service.devices.impl;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDevice;
import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.dto.DTO;
import com.gmail.gstewart05.service.impl.AbstractServiceImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractDeviceServiceImpl< T extends AbstractDevice, S extends DTO > extends AbstractServiceImpl< T > implements AbstractDeviceService< T, S >
{
	@Override
	public abstract AbstractDeviceRepository< T > getRepository();

	@Override
	public T getByName( String pName )
	{
		return getRepository().findByNameIgnoreCase( pName );
	}
}
