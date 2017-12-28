package com.gmail.gstewart05.deviceservice.volume.service;

import com.gmail.gstewart05.deviceservice.volume.model.Volume;
import com.gmail.gstewart05.dto.VolumeDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.wrappers.DoubleSensorServiceImpl;

public interface VolumeService extends NamedService< Volume >, DoubleSensorServiceImpl< Volume, VolumeDTO >
{
}
