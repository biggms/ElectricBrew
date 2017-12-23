package com.gmail.gstewart05.deviceservice.flow.controller;

import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.flow.model.devices.Flow;
import com.gmail.gstewart05.deviceservice.flow.service.FlowService;
import com.gmail.gstewart05.dto.FlowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/flow/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class FlowController extends AbstractDeviceController< Flow, FlowDTO >
{
	@Autowired
	FlowService theFlowService;

	@Override
	public FlowService getService()
	{
		return theFlowService;
	}

	@Override
	public String getSimpleName()
	{
		return Flow.class.getSimpleName();
	}
}
