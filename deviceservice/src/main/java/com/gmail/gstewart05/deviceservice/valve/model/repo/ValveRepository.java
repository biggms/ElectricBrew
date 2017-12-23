package com.gmail.gstewart05.deviceservice.valve.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.valve.model.devices.Valve;
import org.springframework.stereotype.Repository;

@Repository
public interface ValveRepository extends AbstractDeviceRepository< Valve >
{
}
