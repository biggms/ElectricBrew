package com.gmail.gstewart05.deviceservice.cooler.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import org.springframework.stereotype.Repository;

@Repository
public interface CoolerRepository extends AbstractDeviceRepository< Cooler >
{
}
