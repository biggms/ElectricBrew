package com.gmail.gstewart05.deviceservice.level.mq;

import com.gmail.gstewart05.deviceservice.level.service.LevelChangeService;
import com.gmail.gstewart05.deviceservice.level.service.LevelService;
import com.gmail.gstewart05.dto.LevelDTO;
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
public class LevelReceiver
{
	@Autowired
	LevelChangeService theLevelChangeService;

	@Autowired
	LevelService theLevelService;

	@Transactional
	@RabbitListener( bindings = @QueueBinding(
			value = @Queue( autoDelete = "true", durable = "false" ),
			exchange = @Exchange( value = "amq.topic", type = "topic", durable = "true" ),
			key = "level.v1.statechange"
	) )
	public void receiveChange( @Payload LevelDTO pLevelDTO, @Header( AmqpHeaders.RECEIVED_ROUTING_KEY ) String pKey ) throws InterruptedException
	{
		theLevelChangeService.handleNewChange( pLevelDTO );
	}
}
