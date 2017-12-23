package com.gmail.gstewart05.mq;

import com.gmail.gstewart05.dto.LogDTO;
import com.gmail.gstewart05.model.Log;
import com.gmail.gstewart05.service.LogService;
import com.gmail.gstewart05.utils.Level;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
public class LogReceiver
{
	@Autowired
	LogService theLogService;

	@Transactional
	@RabbitListener( bindings = @QueueBinding(
			value = @Queue( autoDelete = "true", durable = "false" ),
			exchange = @Exchange( value = "amq.topic", type = "topic", durable = "true" ),
			key = "logging.v1.log"
	) )
	public void receive( @Payload LogDTO pLogDTO, @Header( AmqpHeaders.RECEIVED_ROUTING_KEY ) String pKey ) throws InterruptedException
	{
		Log lLog = new Log();
		lLog.setLevel( Level.valueOf( pLogDTO.getLevel() ) );
		lLog.setMessage( pLogDTO.getMessage() );

		lLog = theLogService.save( lLog );
		log.info( "{}", lLog );
	}
}
