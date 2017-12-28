package com.gmail.gstewart05.deviceservice.heater.mq;

import com.gmail.gstewart05.deviceservice.heater.service.HeaterService;
import com.gmail.gstewart05.dto.HeaterDTO;
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
public class HeaterReceiver
{
	@Autowired
	HeaterService theHeaterService;

	@Transactional
	@RabbitListener( bindings = @QueueBinding(
			value = @Queue( autoDelete = "true", durable = "false" ),
			exchange = @Exchange( value = "amq.topic", type = "topic", durable = "true" ),
			key = "heater.v1.statechange"
	) )
	public void receiveStateChange( @Payload HeaterDTO pHeaterDTO, @Header( AmqpHeaders.RECEIVED_ROUTING_KEY ) String pKey ) throws InterruptedException
	{
		theHeaterService.handleNewStateChange( pHeaterDTO );
	}

	@Transactional
	@RabbitListener( bindings = @QueueBinding(
			value = @Queue( autoDelete = "true", durable = "false" ),
			exchange = @Exchange( value = "amq.topic", type = "topic", durable = "true" ),
			key = "heater.v1.valuechange"
	) )
	public void receiveValueChange( @Payload HeaterDTO pHeaterDTO, @Header( AmqpHeaders.RECEIVED_ROUTING_KEY ) String pKey ) throws InterruptedException
	{
		theHeaterService.handleNewValueChange( pHeaterDTO );
	}
}
