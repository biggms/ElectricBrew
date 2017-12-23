package com.gmail.gstewart05.deviceservice.temperature.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDoubleDeviceChangeService;
import com.gmail.gstewart05.deviceservice.temperature.model.change.TemperatureChange;
import com.gmail.gstewart05.dto.TemperatureDTO;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;

public interface TemperatureChangeService extends AbstractDoubleDeviceChangeService< TemperatureProbe, TemperatureDTO, TemperatureChange >
{
}
