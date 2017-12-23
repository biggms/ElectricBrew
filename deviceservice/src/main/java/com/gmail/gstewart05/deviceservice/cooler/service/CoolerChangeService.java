package com.gmail.gstewart05.deviceservice.cooler.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractBooleanDeviceChangeService;
import com.gmail.gstewart05.deviceservice.cooler.model.change.CoolerChange;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import com.gmail.gstewart05.dto.CoolerDTO;

public interface CoolerChangeService extends AbstractBooleanDeviceChangeService< Cooler, CoolerDTO, CoolerChange >
{
}
