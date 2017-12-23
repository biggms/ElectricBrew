package com.gmail.gstewart05.deviceservice.temperature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.Temperature;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureService;
import com.gmail.gstewart05.dto.TemperatureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/temperature/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class TemperatureController extends AbstractDeviceController< Temperature, TemperatureDTO >
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	TemperatureService theTemperatureService;

	@Override
	public TemperatureService getService()
	{
		return theTemperatureService;
	}

	@Override
	public String getSimpleName()
	{
		return Temperature.class.getSimpleName();
	}

	@PostMapping( "" )
	@Override
	public ResponseEntity create( @RequestBody Temperature pEntity )
	{
		Temperature lEntity = theTemperatureService.getByMac( pEntity.getMac() );
		if( lEntity != null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 400 ).put( "message", "Device already assigned" );
			return new ResponseEntity( lNode.toString(), HttpStatus.BAD_REQUEST );
		}
		lEntity = theTemperatureService.getByName( pEntity.getName() );
		if( lEntity != null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 400 ).put( "message", "Device already assigned" );
			return new ResponseEntity( lNode.toString(), HttpStatus.BAD_REQUEST );
		}
		theTemperatureService.save( pEntity );
		return new ResponseEntity( pEntity, HttpStatus.CREATED );
	}
}
