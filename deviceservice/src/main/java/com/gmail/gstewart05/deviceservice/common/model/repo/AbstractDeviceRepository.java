package com.gmail.gstewart05.deviceservice.common.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractDeviceRepository< T extends AbstractDevice > extends CrudRepository< T, String >
{
	T findByNameIgnoreCase( String pName );
}
