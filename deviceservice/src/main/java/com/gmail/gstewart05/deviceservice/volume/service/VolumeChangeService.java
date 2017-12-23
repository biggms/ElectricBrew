package com.gmail.gstewart05.deviceservice.volume.service;

import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDoubleDeviceChangeService;
import com.gmail.gstewart05.deviceservice.volume.model.change.VolumeChange;
import com.gmail.gstewart05.deviceservice.volume.model.devices.Volume;
import com.gmail.gstewart05.dto.VolumeDTO;

public interface VolumeChangeService extends AbstractDoubleDeviceChangeService< Volume, VolumeDTO, VolumeChange >
{
}
