package com.gmail.gstewart05.utils;

import com.gmail.gstewart05.dto.LogDTO;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class LogUtil
{
	private static LogUtil theLogUtil;
	@Autowired
	private RabbitTemplate theTemplate;
	private TopicExchange theExchange = new TopicExchange( "amq.topic" );

	public void info( String pMessage, Object... pObjects )
	{
		log( Level.INFO, pMessage, pObjects );
	}

	public void warn( String pMessage, Object... pObjects )
	{
		log( Level.WARN, pMessage, pObjects );
	}

	public void debug( String pMessage, Object... pObjects )
	{
		log( Level.DEBUG, pMessage, pObjects );
	}

	public void error( String pMessage, Object... pObjects )
	{
		log( Level.ERROR, pMessage, pObjects );
	}

	public void trace( String pMessage, Object... pObjects )
	{
		log( Level.TRACE, pMessage, pObjects );
	}

	private void log( Level pLevel, String pMessage, Object... pObjects )
	{
		LogDTO lLogDTO = new LogDTO();
		lLogDTO.setMessage( MessageFormat.format( pMessage, pObjects ) );
		lLogDTO.setLevel( pLevel );
		theTemplate.convertAndSend( theExchange.getName(), "logging.v1.log", lLogDTO );
	}
}
