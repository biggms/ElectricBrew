package com.gmail.gstewart05.deviceservice.heatingelement.mq;

import com.gmail.gstewart05.dto.HeatingElementDTO;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementChangeService;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementService;
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
public class HeatingElementReceiver
{
	@Autowired
	HeatingElementChangeService theHeatingElementChangeService;

	@Autowired
	HeatingElementService theHeatingElementService;

	@Transactional
	@RabbitListener( bindings = @QueueBinding(
			value = @Queue( autoDelete = "true", durable = "false" ),
			exchange = @Exchange( value = "amq.topic", type = "topic", durable = "true" ),
			key = "heatingelement.v1.statechange"
	) )
	public void receiveChange( @Payload HeatingElementDTO pHeatingElementDTO, @Header( AmqpHeaders.RECEIVED_ROUTING_KEY ) String pKey ) throws InterruptedException
	{
		theHeatingElementChangeService.handleNewChange( pHeatingElementDTO );
	}

	@Transactional
	@RabbitListener( bindings = @QueueBinding(
			value = @Queue( autoDelete = "true", durable = "false" ),
			exchange = @Exchange( value = "amq.topic", type = "topic", durable = "true" ),
			key = "heatingelement.v1.setstate"
	) )
	public void receiveChangeRequest( @Payload HeatingElementDTO pHeatingElementDTO, @Header( AmqpHeaders.RECEIVED_ROUTING_KEY ) String pKey ) throws InterruptedException
	{
		theHeatingElementService.handleChangeRequest( pHeatingElementDTO );
	}
}
