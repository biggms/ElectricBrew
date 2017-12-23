package com.gmail.gstewart05.deviceservice.common.service.change;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractDoubleDeviceChange;
import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDoubleDevice;
import com.gmail.gstewart05.dto.DoubleDTO;

public interface AbstractDoubleDeviceChangeService< T extends AbstractDoubleDevice, S extends DoubleDTO, R extends AbstractDoubleDeviceChange< T > > extends AbstractDeviceChangeService< T, S, R >
{
}
