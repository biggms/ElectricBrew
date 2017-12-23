package com.gmail.gstewart05.deviceservice.volume.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.volume.model.change.VolumeChange;
import com.gmail.gstewart05.deviceservice.volume.model.devices.Volume;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeChangeRepository extends AbstractDeviceChangeRepository< Volume, VolumeChange >
{
}
