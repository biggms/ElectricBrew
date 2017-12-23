package com.gmail.gstewart05.deviceservice.flow.model.repo;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.flow.model.change.FlowChange;
import com.gmail.gstewart05.deviceservice.flow.model.devices.Flow;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowChangeRepository extends AbstractDeviceChangeRepository< Flow, FlowChange >
{
}
