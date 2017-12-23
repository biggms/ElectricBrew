package com.gmail.gstewart05.deviceservice.flow.mq;

import com.gmail.gstewart05.deviceservice.flow.service.FlowChangeService;
import com.gmail.gstewart05.deviceservice.flow.service.FlowService;
import com.gmail.gstewart05.dto.FlowDTO;
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
public class FlowReceiver
{
	@Autowired
	FlowChangeService theFlowChangeService;

	@Autowired
	FlowService theFlowService;

	@Transactional
	@RabbitListener( bindings = @QueueBinding(
			value = @Queue( autoDelete = "true", durable = "false" ),
			exchange = @Exchange( value = "amq.topic", type = "topic", durable = "true" ),
			key = "flow.v1.statechange"
	) )
	public void receiveChange( @Payload FlowDTO pFlowDTO, @Header( AmqpHeaders.RECEIVED_ROUTING_KEY ) String pKey ) throws InterruptedException
	{
		theFlowChangeService.handleNewChange( pFlowDTO );
	}
}
