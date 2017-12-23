package com.gmail.gstewart05.deviceservice.common.service.change;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractBooleanDeviceChange;
import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanDevice;
import com.gmail.gstewart05.dto.BooleanDTO;

public interface AbstractBooleanDeviceChangeService< T extends AbstractBooleanDevice, S extends BooleanDTO, R extends AbstractBooleanDeviceChange< T > > extends AbstractDeviceChangeService< T, S, R >
{
}
