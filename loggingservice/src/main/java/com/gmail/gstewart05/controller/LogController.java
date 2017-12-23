package com.gmail.gstewart05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gmail.gstewart05.utils.Level;

@RequestMapping( "/log/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class LogController
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	LogService theLogService;

	@GetMapping( "" )
	public ResponseEntity list()
	{
		return new ResponseEntity( theLogService.getAll(), HttpStatus.OK );
	}

	@GetMapping( "/level/{name}" )
	public ResponseEntity search( @PathVariable( "name" ) String pName )
	{
		Level lLevel;
		try
		{
			lLevel = Level.valueOf( pName );
			if( lLevel == null )
			{
				ObjectNode lNode = theObjectMapper.createObjectNode();
				lNode.put( "status", 404 ).put( "message", "No Level of mame: " + pName );
				return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
			}
		}
		catch( Exception e )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 404 ).put( "message", "No Level of mame: " + pName );
			return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
		}
		return new ResponseEntity( theLogService.getByLevel( lLevel ), HttpStatus.OK );
	}
}
