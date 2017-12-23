package com.gmail.gstewart05.deviceservice.volume.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.volume.model.devices.Volume;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeRepository extends AbstractDeviceRepository< Volume >
{
}
