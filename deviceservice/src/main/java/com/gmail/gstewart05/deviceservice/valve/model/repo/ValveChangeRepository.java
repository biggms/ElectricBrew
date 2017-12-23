package com.gmail.gstewart05.deviceservice.valve.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.valve.model.change.ValveChange;
import com.gmail.gstewart05.deviceservice.valve.model.devices.Valve;
import org.springframework.stereotype.Repository;

@Repository
public interface ValveChangeRepository extends AbstractDeviceChangeRepository< Valve, ValveChange >
{
}
