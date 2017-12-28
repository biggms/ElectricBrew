package com.gmail.gstewart05.deviceservice.flow.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.gstewart05.controller.NamedController;
import com.gmail.gstewart05.deviceservice.flow.model.Flow;
import com.gmail.gstewart05.deviceservice.flow.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/flow/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class FlowController extends NamedController< Flow >
{
	@Autowired
	FlowService theFlowService;

	@Override
	public FlowService getService()
	{
		return theFlowService;
	}
}
