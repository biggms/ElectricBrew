package com.gmail.gstewart05.deviceservice.temperature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/temperatureprobe/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class TemperatureProbeController
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	TemperatureProbeService theTemperatureProbeService;

	@GetMapping( "" )
	public ResponseEntity list()
	{
		return new ResponseEntity( theTemperatureProbeService.getAll(), HttpStatus.OK );
	}

	@PostMapping( "" )
	public ResponseEntity create( @RequestBody TemperatureProbe pEntity )
	{
		TemperatureProbe lProbe = theTemperatureProbeService.getByMac( pEntity.getMac() );
		if( lProbe != null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 400 ).put( "message", "Device already assigned" );
			return new ResponseEntity( lNode.toString(), HttpStatus.BAD_REQUEST );
		}
		theTemperatureProbeService.save( pEntity );
		return new ResponseEntity( pEntity, HttpStatus.CREATED );
	}

	@PutMapping( "/{id}" )
	@SuppressWarnings("Duplicates")
	public ResponseEntity update( @PathVariable( "id" ) String pID, @RequestBody TemperatureProbe pEntity )
	{
		TemperatureProbe lEntity = theTemperatureProbeService.getById( pID );
		if( lEntity != null )
		{
			if( pEntity.getId().equals( pID ) )
			{
				pEntity.setId( pID );
				theTemperatureProbeService.save( pEntity );
				return new ResponseEntity( pEntity, HttpStatus.OK );
			}
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 400 ).put( "message", "IDs must match" );
			return new ResponseEntity( lNode.toString(), HttpStatus.BAD_REQUEST );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No TemperatureProbe of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}

	@DeleteMapping( "/{id}" )
	@SuppressWarnings("Duplicates")
	public ResponseEntity delete( @PathVariable( "id" ) String pID )
	{
		TemperatureProbe lEntity = theTemperatureProbeService.getById( pID );
		if( lEntity != null )
		{
			theTemperatureProbeService.delete( lEntity );
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 200 ).put( "message", "OK" );
			return new ResponseEntity( lNode.toString(), HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No TemperatureProbe of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}

	@GetMapping( "/search/{name}" )
	public ResponseEntity search( @PathVariable( "name" ) String pName )
	{
		TemperatureProbe lEntity = theTemperatureProbeService.getByName( pName );
		if( lEntity != null )
		{
			return new ResponseEntity( lEntity, HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No TemperatureProbe of mame: " + pName );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}

	@GetMapping( "/{id}" )
	public ResponseEntity get( @PathVariable( "id" ) String pID )
	{
		TemperatureProbe lEntity = theTemperatureProbeService.getById( pID );
		if( lEntity != null )
		{
			return new ResponseEntity( lEntity, HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No TemperatureProbe of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}
}
