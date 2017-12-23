package com.gmail.gstewart05.deviceservice.temperature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDeviceChangeService;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;
import com.gmail.gstewart05.deviceservice.temperature.model.change.TemperatureChange;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureProbeService;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureChangeService;
import com.gmail.gstewart05.dto.TemperatureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/temperaturereading/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class TemperatureChangeController extends AbstractDeviceChangeController< TemperatureProbe, TemperatureDTO, TemperatureChange >
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	TemperatureChangeService theTemperatureChangeService;

	@Autowired
	TemperatureProbeService theTemperatureProbeService;

	@Override
	public TemperatureChangeService getChangeService()
	{
		return theTemperatureChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return TemperatureChange.class.getSimpleName();
	}

	@Override
	public TemperatureProbeService getDeviceService()
	{
		return theTemperatureProbeService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return TemperatureProbe.class.getSimpleName();
	}
}
