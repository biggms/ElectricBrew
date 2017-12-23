package com.gmail.gstewart05.deviceservice.temperature.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureProbeRepository extends AbstractDeviceRepository< TemperatureProbe >
{
	TemperatureProbe findByMacIgnoreCase( String pMac );
}
