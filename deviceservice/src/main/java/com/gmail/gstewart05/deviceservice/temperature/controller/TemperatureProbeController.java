package com.gmail.gstewart05.deviceservice.temperature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureProbeService;
import com.gmail.gstewart05.dto.TemperatureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/temperatureprobe/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class TemperatureProbeController extends AbstractDeviceController< TemperatureProbe, TemperatureDTO >
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	TemperatureProbeService theTemperatureProbeService;

	@Override
	public TemperatureProbeService getService()
	{
		return theTemperatureProbeService;
	}

	@Override
	public String getSimpleName()
	{
		return TemperatureProbe.class.getSimpleName();
	}

	@PostMapping( "" )
	@Override
	public ResponseEntity create( @RequestBody TemperatureProbe pEntity )
	{
		TemperatureProbe lProbe = theTemperatureProbeService.getByMac( pEntity.getMac() );
		if( lProbe != null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 400 ).put( "message", "Device already assigned" );
			return new ResponseEntity( lNode.toString(), HttpStatus.BAD_REQUEST );
		}
		lProbe = theTemperatureProbeService.getByName( pEntity.getName() );
		if( lProbe != null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 400 ).put( "message", "Device already assigned" );
			return new ResponseEntity( lNode.toString(), HttpStatus.BAD_REQUEST );
		}
		theTemperatureProbeService.save( pEntity );
		return new ResponseEntity( pEntity, HttpStatus.CREATED );
	}
}
