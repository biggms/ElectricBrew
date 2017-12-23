package com.gmail.gstewart05.deviceservice.flow.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractBooleanDeviceChangeService;
import com.gmail.gstewart05.deviceservice.flow.model.change.FlowChange;
import com.gmail.gstewart05.deviceservice.flow.model.devices.Flow;
import com.gmail.gstewart05.dto.FlowDTO;

public interface FlowChangeService extends AbstractBooleanDeviceChangeService< Flow, FlowDTO, FlowChange >
{
}
