package com.gmail.gstewart05.deviceservice.heatingelement.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractBooleanDeviceChangeService;
import com.gmail.gstewart05.dto.HeatingElementDTO;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;
import com.gmail.gstewart05.deviceservice.heatingelement.model.change.HeatingElementChange;

import java.util.List;

public interface HeatingElementChangeService extends AbstractBooleanDeviceChangeService< HeatingElement, HeatingElementDTO, HeatingElementChange >
{
}
