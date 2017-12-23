package com.gmail.gstewart05.deviceservice.temperature.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.temperature.model.change.TemperatureChange;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.Temperature;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureChangeRepository extends AbstractDeviceChangeRepository< Temperature, TemperatureChange >
{
}
