package com.gmail.gstewart05.deviceservice.heater.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.heater.model.change.HeaterChange;
import com.gmail.gstewart05.deviceservice.heater.model.devices.Heater;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaterChangeRepository extends AbstractDeviceChangeRepository< Heater, HeaterChange >
{
}
