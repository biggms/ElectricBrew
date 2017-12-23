package com.gmail.gstewart05.deviceservice.common.service.change;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractDeviceChange;
import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDevice;
import com.gmail.gstewart05.dto.DTO;
import com.gmail.gstewart05.service.AbstractService;

import java.util.List;

public interface AbstractDeviceChangeService< T extends AbstractDevice, S extends DTO, R extends AbstractDeviceChange< T > > extends AbstractService< R >
{
	List< R > getByDevice( T pDevice );

	void handleNewChange( S pDTO );
}
