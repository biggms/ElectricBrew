package com.gmail.gstewart05.deviceservice.flow.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.flow.model.devices.Flow;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRepository extends AbstractDeviceRepository< Flow >
{
}
