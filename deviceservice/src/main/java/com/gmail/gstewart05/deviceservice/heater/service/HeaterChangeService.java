package com.gmail.gstewart05.deviceservice.heater.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractBooleanDeviceChangeService;
import com.gmail.gstewart05.deviceservice.heater.model.change.HeaterChange;
import com.gmail.gstewart05.deviceservice.heater.model.devices.Heater;
import com.gmail.gstewart05.dto.HeaterDTO;

public interface HeaterChangeService extends AbstractBooleanDeviceChangeService< Heater, HeaterDTO, HeaterChange >
{
}
