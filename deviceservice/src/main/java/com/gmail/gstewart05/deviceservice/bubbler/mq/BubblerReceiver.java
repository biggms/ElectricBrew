package com.gmail.gstewart05.deviceservice.bubbler.mq;

import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerChangeService;
import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerService;
import com.gmail.gstewart05.dto.BubblerDTO;
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
public class BubblerReceiver
{
	@Autowired
	BubblerChangeService theBubblerChangeService;

	@Autowired
	BubblerService theBubblerService;

	@Transactional
	@RabbitListener( bindings = @QueueBinding(
			value = @Queue( autoDelete = "true", durable = "false" ),
			exchange = @Exchange( value = "amq.topic", type = "topic", durable = "true" ),
			key = "bubbler.v1.statechange"
	) )
	public void receiveChange( @Payload BubblerDTO pBubblerDTO, @Header( AmqpHeaders.RECEIVED_ROUTING_KEY ) String pKey ) throws InterruptedException
	{
		theBubblerChangeService.handleNewChange( pBubblerDTO );
	}
}
