package com.gmail.gstewart05.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.service.NamedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class NamedChangeController< T extends NamedEntity > extends BaseChangeController< T >
{
	@GetMapping( "/search/{name}" )
	public ResponseEntity search( @PathVariable( "name" ) String pName )
	{
		T lEntity = getService().getByName( pName );
		if( lEntity == null )
		{
			ObjectNode lNode = theObjectMapper.createObjectNode();
			lNode.put( "status", 404 ).put( "message", "No " + getService().getSimpleName() + " of name: " + pName );
			return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
		}
		return get( lEntity.getId() );
	}

	@Override
	public abstract NamedService< T > getService();
}
