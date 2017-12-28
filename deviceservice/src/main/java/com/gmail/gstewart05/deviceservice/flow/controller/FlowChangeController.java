package com.gmail.gstewart05.deviceservice.flow.controller;

import com.gmail.gstewart05.controller.NamedChangeController;
import com.gmail.gstewart05.deviceservice.flow.model.Flow;
import com.gmail.gstewart05.deviceservice.flow.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/flowchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class FlowChangeController extends NamedChangeController< Flow >
{
	@Autowired
	FlowService theFlowService;

	@Override
	public FlowService getService()
	{
		return theFlowService;
	}

}
