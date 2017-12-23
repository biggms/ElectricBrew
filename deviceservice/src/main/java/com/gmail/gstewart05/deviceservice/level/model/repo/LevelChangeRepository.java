package com.gmail.gstewart05.deviceservice.level.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.level.model.change.LevelChange;
import com.gmail.gstewart05.deviceservice.level.model.devices.Level;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelChangeRepository extends AbstractDeviceChangeRepository< Level, LevelChange >
{
}
