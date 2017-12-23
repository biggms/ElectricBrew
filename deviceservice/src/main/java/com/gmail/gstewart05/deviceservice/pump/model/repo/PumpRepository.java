package com.gmail.gstewart05.deviceservice.pump.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.pump.model.devices.Pump;
import org.springframework.stereotype.Repository;

@Repository
public interface PumpRepository extends AbstractDeviceRepository< Pump >
{
}
