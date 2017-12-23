package com.gmail.gstewart05.deviceservice.temperature.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.Temperature;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends AbstractDeviceRepository< Temperature >
{
	Temperature findByMacIgnoreCase( String pMac );
}
