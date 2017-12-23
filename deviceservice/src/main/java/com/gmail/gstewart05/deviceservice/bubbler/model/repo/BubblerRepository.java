package com.gmail.gstewart05.deviceservice.bubbler.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.bubbler.model.devices.Bubbler;
import org.springframework.stereotype.Repository;

@Repository
public interface BubblerRepository extends AbstractDeviceRepository< Bubbler >
{
}
