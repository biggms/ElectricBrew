package com.gmail.gstewart05.deviceservice.heatingelement.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;
import com.gmail.gstewart05.deviceservice.heatingelement.model.change.HeatingElementChange;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatingElementChangeRepository extends AbstractDeviceChangeRepository< HeatingElement, HeatingElementChange >
{
}
