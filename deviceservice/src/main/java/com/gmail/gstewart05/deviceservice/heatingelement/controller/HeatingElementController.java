package com.gmail.gstewart05.deviceservice.heatingelement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/heatingelement/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class HeatingElementController
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	HeatingElementService theHeatingElementService;

	@GetMapping( "" )
	public ResponseEntity list()
	{
		return new ResponseEntity( theHeatingElementService.getAll(), HttpStatus.OK );
	}

	@PostMapping( "" )
	public ResponseEntity create( @RequestBody HeatingElement pEntity )
	{
		HeatingElement lElement = theHeatingElementService.getByName( pEntity.getName() );
		if( lElement != null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 400 ).put( "message", "Device already assigned" );
			return new ResponseEntity( lNode.toString(), HttpStatus.BAD_REQUEST );
		}
		theHeatingElementService.save( pEntity );
		return new ResponseEntity( pEntity, HttpStatus.CREATED );
	}

	@PutMapping( "/{id}" )
	@SuppressWarnings("Duplicates")
	public ResponseEntity update( @PathVariable( "id" ) String pID, @RequestBody HeatingElement pEntity )
	{
		HeatingElement lEntity = theHeatingElementService.getById( pID );
		if( lEntity != null )
		{
			if( pEntity.getId().equals( pID ) )
			{
				pEntity.setId( pID );
				theHeatingElementService.save( pEntity );
				return new ResponseEntity( pEntity, HttpStatus.OK );
			}
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 400 ).put( "message", "IDs must match" );
			return new ResponseEntity( lNode.toString(), HttpStatus.BAD_REQUEST );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No HeatingElement of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}

	@DeleteMapping( "/{id}" )
	@SuppressWarnings("Duplicates")
	public ResponseEntity delete( @PathVariable( "id" ) String pID )
	{
		HeatingElement lEntity = theHeatingElementService.getById( pID );
		if( lEntity != null )
		{
			theHeatingElementService.delete( lEntity );
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 200 ).put( "message", "OK" );
			return new ResponseEntity( lNode.toString(), HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No HeatingElement of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}

	@GetMapping( "/search/{name}" )
	public ResponseEntity search( @PathVariable( "name" ) String pName )
	{
		HeatingElement lEntity = theHeatingElementService.getByName( pName );
		if( lEntity != null )
		{
			return new ResponseEntity( lEntity, HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No HeatingElement of mame: " + pName );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}

	@GetMapping( "/{id}" )
	public ResponseEntity get( @PathVariable( "id" ) String pID )
	{
		HeatingElement lEntity = theHeatingElementService.getById( pID );
		if( lEntity != null )
		{
			return new ResponseEntity( lEntity, HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No HeatingElement of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}
}
