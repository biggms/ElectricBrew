package com.gmail.gstewart05.deviceservice.common.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.model.change.AbstractDeviceChange;
import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDevice;
import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDeviceChangeService;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.dto.DTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings( "unchecked" )
public abstract class AbstractDeviceChangeController< T extends AbstractDevice, S extends DTO, R extends AbstractDeviceChange< T > >
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	public abstract AbstractDeviceChangeService< T, S, R > getChangeService();
	public abstract String getSimpleName();

	public abstract AbstractDeviceService< T, S > getDeviceService();
	public abstract String getDeviceSimpleName();

	@GetMapping( "" )
	public ResponseEntity list()
	{
		return new ResponseEntity( getChangeService().getAll(), HttpStatus.OK );
	}

	@GetMapping( "/search/{name}" )
	public ResponseEntity search( @PathVariable( "name" ) String pName )
	{
		T lDevice = getDeviceService().getByName( pName );
		if( lDevice == null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 404 ).put( "message", "No " + getDeviceSimpleName() + " of mame: " + pName );
			return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
		}
		return new ResponseEntity( getChangeService().getByDevice( lDevice ), HttpStatus.OK );
	}

	@GetMapping( "/{id}" )
	public ResponseEntity get( @PathVariable( "id" ) String pID )
	{
		R lEntity = getChangeService().getById( pID );
		if( lEntity != null )
		{
			return new ResponseEntity( lEntity, HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No " + getSimpleName() + " of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}
}
