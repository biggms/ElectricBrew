package com.gmail.gstewart05.deviceservice.bubbler.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.bubbler.model.change.BubblerChange;
import com.gmail.gstewart05.deviceservice.bubbler.model.devices.Bubbler;
import org.springframework.stereotype.Repository;

@Repository
public interface BubblerChangeRepository extends AbstractDeviceChangeRepository< Bubbler, BubblerChange >
{
}
