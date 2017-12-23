package com.gmail.gstewart05.deviceservice.common.service.devices;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDoubleDevice;
import com.gmail.gstewart05.dto.DoubleDTO;

public interface AbstractDoubleDeviceService< T extends AbstractDoubleDevice, S extends DoubleDTO > extends AbstractDeviceService< T, S >
{
}
