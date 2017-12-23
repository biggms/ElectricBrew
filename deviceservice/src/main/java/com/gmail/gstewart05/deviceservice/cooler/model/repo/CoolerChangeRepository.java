package com.gmail.gstewart05.deviceservice.cooler.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.cooler.model.change.CoolerChange;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import org.springframework.stereotype.Repository;

@Repository
public interface CoolerChangeRepository extends AbstractDeviceChangeRepository< Cooler, CoolerChange >
{
}
