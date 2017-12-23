package com.gmail.gstewart05.deviceservice.heatingelement.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatingElementRepository extends AbstractDeviceRepository< HeatingElement >
{
}
