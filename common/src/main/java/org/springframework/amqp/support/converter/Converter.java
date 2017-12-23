package org.springframework.amqp.support.converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Converter extends Jackson2JsonMessageConverter
{
	static final String thePackage = "com.gmail.gstewart05.dto";

	ObjectMapper theMapper = new ObjectMapper();

	@Override
	public Object fromMessage( Message pMessage )
	{
		try
		{
			if( pMessage.getMessageProperties().getInferredArgumentType() == null )
			{
				String lMessage = new String( pMessage.getBody() );
				JsonNode lNode = theMapper.readValue( lMessage, JsonNode.class );
				log.info( "Unknown class type found, checking the class field: {}", lNode.get( "type" ).asText() );
				Class lClass = Class.forName( thePackage + lNode.get( "type" ).asText() );
				pMessage.getMessageProperties().setInferredArgumentType( lClass );
			}

			pMessage.getMessageProperties().setContentType( "application/json" );
			return super.fromMessage( pMessage );
		}
		catch( Exception e )
		{
			log.error( "Error converting message {}", pMessage, e );
		}
		return null;
	}
}
