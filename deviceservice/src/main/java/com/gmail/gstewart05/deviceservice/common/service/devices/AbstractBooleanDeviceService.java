package com.gmail.gstewart05.deviceservice.common.service.devices;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanDevice;
import com.gmail.gstewart05.dto.BooleanDTO;

public interface AbstractBooleanDeviceService< T extends AbstractBooleanDevice, S extends BooleanDTO > extends AbstractDeviceService< T, S >
{
}
