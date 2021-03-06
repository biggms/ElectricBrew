package com.gmail.gstewart05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.service.NamedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings( "unchecked" )
public abstract class NamedController< T extends NamedEntity >
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	public abstract NamedService< T > getService();

	@GetMapping( "" )
	public ResponseEntity list()
	{
		return new ResponseEntity( getService().getAll(), HttpStatus.OK );
	}

	@PostMapping( "" )
	public ResponseEntity create( @RequestBody T pEntity )
	{
		T lEntity = getService().getByName( pEntity.getName() );
		if( lEntity != null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 400 ).put( "message", "Device already assigned" );
			return new ResponseEntity( lNode.toString(), HttpStatus.BAD_REQUEST );
		}
		getService().save( pEntity );
		return new ResponseEntity( pEntity, HttpStatus.CREATED );
	}

	@PutMapping( "/{id}" )
	@SuppressWarnings( "Duplicates" )
	public ResponseEntity update( @PathVariable( "id" ) String pID, @RequestBody T pEntity )
	{
		T lEntity = getService().getById( pID );
		if( lEntity != null )
		{
			if( pEntity.getId().equals( pID ) )
			{
				pEntity.setId( pID );
				getService().save( pEntity );
				return new ResponseEntity( pEntity, HttpStatus.OK );
			}
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 400 ).put( "message", "IDs must match" );
			return new ResponseEntity( lNode.toString(), HttpStatus.BAD_REQUEST );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No " + getService().getSimpleName() + " of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}

	@DeleteMapping( "/{id}" )
	@SuppressWarnings( "Duplicates" )
	public ResponseEntity delete( @PathVariable( "id" ) String pID )
	{
		T lEntity = getService().getById( pID );
		if( lEntity != null )
		{
			getService().delete( lEntity );
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 200 ).put( "message", "OK" );
			return new ResponseEntity( lNode.toString(), HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No " + getService().getSimpleName() + " of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}

	@GetMapping( "/search/{name}" )
	public ResponseEntity search( @PathVariable( "name" ) String pName )
	{
		T lEntity = getService().getByName( pName );
		if( lEntity != null )
		{
			return new ResponseEntity( lEntity, HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No " + getService().getSimpleName() + " of Name: " + pName );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}

	@GetMapping( "/{id}" )
	public ResponseEntity get( @PathVariable( "id" ) String pID )
	{
		T lEntity = getService().getById( pID );
		if( lEntity != null )
		{
			return new ResponseEntity( lEntity, HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No " + getService().getSimpleName() + " of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}
}
