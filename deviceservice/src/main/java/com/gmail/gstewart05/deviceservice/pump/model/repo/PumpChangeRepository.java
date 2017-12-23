package com.gmail.gstewart05.deviceservice.pump.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.pump.model.change.PumpChange;
import com.gmail.gstewart05.deviceservice.pump.model.devices.Pump;
import org.springframework.stereotype.Repository;

@Repository
public interface PumpChangeRepository extends AbstractDeviceChangeRepository< Pump, PumpChange >
{
}
