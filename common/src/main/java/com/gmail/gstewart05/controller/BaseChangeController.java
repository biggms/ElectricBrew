package com.gmail.gstewart05.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.model.BaseEntity;
import com.gmail.gstewart05.service.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.DefaultRevisionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.envers.repository.support.DefaultRevisionMetadata;
import org.springframework.data.history.Revision;
import org.springframework.data.history.RevisionMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Field;
import java.util.List;

@Slf4j
@SuppressWarnings( "unchecked" )
public abstract class BaseChangeController< T extends BaseEntity >
{
	protected static final Field theEntityField;

	static
	{
		theEntityField = ReflectionUtils.findField( DefaultRevisionMetadata.class, "entity" );
		ReflectionUtils.makeAccessible( theEntityField );
	}

	ObjectMapper theObjectMapper;

	public BaseChangeController()
	{
		theObjectMapper = new ObjectMapper();
		theObjectMapper.configure( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		theObjectMapper.findAndRegisterModules();
		theObjectMapper.setSerializationInclusion( JsonInclude.Include.NON_NULL );
	}

	@PersistenceContext
	private EntityManager theEntityManager;

	public abstract AbstractService< T > getService();

	@GetMapping( "/{id}" )
	public ResponseEntity get( @PathVariable( "id" ) String pID )
	{
		List< Revision< Integer, T > > lRevisions = getService().getAllRevisions( pID );
		if( lRevisions != null )
		{
			ArrayNode lNode = theObjectMapper.createArrayNode();
			for( Revision< Integer, T > lRev : lRevisions )
			{
				DefaultRevisionEntity lEntity = ( DefaultRevisionEntity ) ReflectionUtils.getField( theEntityField, lRev.getMetadata() );
				ObjectNode lObjectNode = theObjectMapper.valueToTree( lRev.getEntity() );
				lObjectNode.put( "timestamp", lEntity.getTimestamp() );
				lNode.add( lObjectNode );
			}
			return new ResponseEntity( lNode, HttpStatus.OK );
		}

		ObjectNode lNode = theObjectMapper.createObjectNode();
		lNode.put( "status", 404 ).put( "message", "No " + getService().getSimpleName() + " of ID: " + pID );
		return new ResponseEntity( lNode.toString(), HttpStatus.NOT_FOUND );
	}
}
