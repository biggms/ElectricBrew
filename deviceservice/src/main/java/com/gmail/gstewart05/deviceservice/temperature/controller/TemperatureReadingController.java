package com.gmail.gstewart05.deviceservice.temperature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;
import com.gmail.gstewart05.deviceservice.temperature.model.change.TemperatureChange;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureProbeService;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/temperaturereading/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class TemperatureReadingController
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	TemperatureChangeService theTemperatureChangeService;

	@Autowired
	TemperatureProbeService theTemperatureProbeService;

	@GetMapping( "" )
	public ResponseEntity list()
	{
		return new ResponseEntity( theTemperatureChangeService.getAll(), HttpStatus.OK );
	}

	@GetMapping( "/search/{name}" )
	public ResponseEntity search( @PathVariable( "name" ) String pName )
	{
		TemperatureProbe lTemperatureProbe = theTemperatureProbeService.getByName( pName );
		if( lTemperatureProbe == null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 404 ).put( "message", "No TemperatureProbe of mame: " + pName );
			return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
		}
		return new ResponseEntity( theTemperatureChangeService.getByDevice( lTemperatureProbe ), HttpStatus.OK );
	}

	@GetMapping( "/{id}" )
	public ResponseEntity get( @PathVariable( "id" ) String pID )
	{
		TemperatureChange lEntity = theTemperatureChangeService.getById( pID );
		if( lEntity != null )
		{
			return new ResponseEntity( lEntity, HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No TemperatureChange of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}
}
