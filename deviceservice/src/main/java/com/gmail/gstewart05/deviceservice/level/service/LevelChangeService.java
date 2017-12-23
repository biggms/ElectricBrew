package com.gmail.gstewart05.deviceservice.level.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractBooleanDeviceChangeService;
import com.gmail.gstewart05.deviceservice.level.model.change.LevelChange;
import com.gmail.gstewart05.deviceservice.level.model.devices.Level;
import com.gmail.gstewart05.dto.LevelDTO;

public interface LevelChangeService extends AbstractBooleanDeviceChangeService< Level, LevelDTO, LevelChange >
{
}
