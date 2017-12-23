package com.gmail.gstewart05.deviceservice.common.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractDeviceChange;
import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractDeviceChangeRepository< T extends AbstractDevice, U extends AbstractDeviceChange< T > > extends CrudRepository< U, String >
{
	U findByDevice( T pDevice );
}
