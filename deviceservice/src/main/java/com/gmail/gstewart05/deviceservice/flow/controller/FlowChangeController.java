package com.gmail.gstewart05.deviceservice.flow.controller;

import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.flow.model.change.FlowChange;
import com.gmail.gstewart05.deviceservice.flow.model.devices.Flow;
import com.gmail.gstewart05.deviceservice.flow.service.FlowChangeService;
import com.gmail.gstewart05.deviceservice.flow.service.FlowService;
import com.gmail.gstewart05.dto.FlowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/flowchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class FlowChangeController extends AbstractDeviceChangeController< Flow, FlowDTO, FlowChange >
{
	@Autowired
	FlowChangeService theFlowChangeService;

	@Autowired
	FlowService theFlowService;

	@Override
	public FlowChangeService getChangeService()
	{
		return theFlowChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return FlowChange.class.getSimpleName();
	}

	@Override
	public FlowService getDeviceService()
	{
		return theFlowService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return Flow.class.getSimpleName();
	}
}
