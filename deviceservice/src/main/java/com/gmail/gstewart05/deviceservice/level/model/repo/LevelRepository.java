package com.gmail.gstewart05.deviceservice.level.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.level.model.devices.Level;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends AbstractDeviceRepository< Level >
{
}
