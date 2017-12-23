package com.gmail.gstewart05.deviceservice.heatingelement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDeviceChangeService;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;
import com.gmail.gstewart05.deviceservice.heatingelement.model.change.HeatingElementChange;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementChangeService;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementService;
import com.gmail.gstewart05.dto.HeatingElementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/heatingelementchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class HeatingElementChangeController extends AbstractDeviceChangeController< HeatingElement, HeatingElementDTO, HeatingElementChange >
{
	@Autowired
	HeatingElementChangeService theHeatingElementChangeService;

	@Autowired
	HeatingElementService theHeatingElementService;

	@Override
	public HeatingElementChangeService getChangeService()
	{
		return theHeatingElementChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return HeatingElementChange.class.getSimpleName();
	}

	@Override
	public HeatingElementService getDeviceService()
	{
		return theHeatingElementService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return HeatingElement.class.getSimpleName();
	}
}
