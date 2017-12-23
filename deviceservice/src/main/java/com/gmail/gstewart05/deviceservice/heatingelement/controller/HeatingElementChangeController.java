package com.gmail.gstewart05.deviceservice.heatingelement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;
import com.gmail.gstewart05.deviceservice.heatingelement.model.change.HeatingElementChange;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementChangeService;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementService;
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
public class HeatingElementChangeController
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	HeatingElementChangeService theHeatingElementChangeService;

	@Autowired
	HeatingElementService theHeatingElementService;

	@GetMapping( "" )
	public ResponseEntity list()
	{
		return new ResponseEntity( theHeatingElementChangeService.getAll(), HttpStatus.OK );
	}

	@GetMapping( "/search/{name}" )
	public ResponseEntity search( @PathVariable( "name" ) String pName )
	{
		HeatingElement lHeatingElement = theHeatingElementService.getByName( pName );
		if( lHeatingElement == null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 404 ).put( "message", "No HeatingElement of mame: " + pName );
			return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
		}
		return new ResponseEntity( theHeatingElementChangeService.getByDevice( lHeatingElement ), HttpStatus.OK );
	}

	@GetMapping( "/{id}" )
	public ResponseEntity get( @PathVariable( "id" ) String pID )
	{
		HeatingElementChange lEntity = theHeatingElementChangeService.getById( pID );
		if( lEntity != null )
		{
			return new ResponseEntity( lEntity, HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No HeatingElementChange of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}
}
