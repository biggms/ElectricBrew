package com.gmail.gstewart05.deviceservice.heatingelement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.HeatingElementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/heatingelement/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class HeatingElementController extends AbstractDeviceController< HeatingElement, HeatingElementDTO >
{
	@Autowired
	HeatingElementService theHeatingElementService;

	@Override
	public HeatingElementService getService()
	{
		return theHeatingElementService;
	}

	@Override
	public String getSimpleName()
	{
		return HeatingElement.class.getSimpleName();
	}
}
