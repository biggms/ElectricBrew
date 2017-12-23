package com.gmail.gstewart05.deviceservice.valve.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractBooleanDeviceChangeService;
import com.gmail.gstewart05.dto.ValveDTO;
import com.gmail.gstewart05.deviceservice.valve.model.devices.Valve;
import com.gmail.gstewart05.deviceservice.valve.model.change.ValveChange;

import java.util.List;

public interface ValveChangeService extends AbstractBooleanDeviceChangeService< Valve, ValveDTO, ValveChange >
{
}
