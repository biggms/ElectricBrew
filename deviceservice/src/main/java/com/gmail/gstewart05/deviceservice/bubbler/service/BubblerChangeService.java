package com.gmail.gstewart05.deviceservice.bubbler.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractBooleanDeviceChangeService;
import com.gmail.gstewart05.deviceservice.bubbler.model.change.BubblerChange;
import com.gmail.gstewart05.deviceservice.bubbler.model.devices.Bubbler;
import com.gmail.gstewart05.dto.BubblerDTO;

public interface BubblerChangeService extends AbstractBooleanDeviceChangeService< Bubbler, BubblerDTO, BubblerChange >
{
}
