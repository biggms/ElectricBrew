package com.gmail.gstewart05.deviceservice.temperature.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDoubleDeviceChangeService;
import com.gmail.gstewart05.deviceservice.temperature.model.change.TemperatureChange;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.Temperature;
import com.gmail.gstewart05.dto.TemperatureDTO;

public interface TemperatureChangeService extends AbstractDoubleDeviceChangeService< Temperature, TemperatureDTO, TemperatureChange >
{
}
