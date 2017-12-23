package com.gmail.gstewart05.deviceservice.pump.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractBooleanDeviceChangeService;
import com.gmail.gstewart05.deviceservice.pump.model.change.PumpChange;
import com.gmail.gstewart05.deviceservice.pump.model.devices.Pump;
import com.gmail.gstewart05.dto.PumpDTO;

public interface PumpChangeService extends AbstractBooleanDeviceChangeService< Pump, PumpDTO, PumpChange >
{
}
