package com.gmail.gstewart05.deviceservice.flow.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractBooleanDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.flow.model.change.FlowChange;
import com.gmail.gstewart05.deviceservice.flow.model.devices.Flow;
import com.gmail.gstewart05.deviceservice.flow.model.repo.FlowChangeRepository;
import com.gmail.gstewart05.deviceservice.flow.service.FlowChangeService;
import com.gmail.gstewart05.deviceservice.flow.service.FlowService;
import com.gmail.gstewart05.dto.FlowDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FlowChangeServiceImpl extends AbstractBooleanDeviceChangeServiceImpl< Flow, FlowDTO, FlowChange > implements FlowChangeService
{
	@Autowired
	FlowChangeRepository theRepository;

	@Autowired
	FlowService theFlowService;

	@Override
	public FlowChangeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public FlowChange getNew()
	{
		return new FlowChange();
	}

	@Override
	public FlowService getDeviceService()
	{
		return theFlowService;
	}

	@Override
	public String getSimpleName()
	{
		return FlowChange.class.getSimpleName();
	}
}
