package com.gmail.gstewart05.deviceservice.heater.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.heater.model.devices.Heater;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaterRepository extends AbstractDeviceRepository< Heater >
{
}
