package com.gmail.gstewart05.deviceservice.volume.mq;

import com.gmail.gstewart05.deviceservice.volume.service.VolumeChangeService;
import com.gmail.gstewart05.dto.VolumeDTO;
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
public class VolumeReceiver
{
	@Autowired
	VolumeChangeService theVolumeChangeService;

	@Transactional
	@RabbitListener( bindings = @QueueBinding(
			value = @Queue( autoDelete = "true", durable = "false" ),
			exchange = @Exchange( value = "amq.topic", type = "topic", durable = "true" ),
			key = "volume.v1.change"
	) )
	public void receive( @Payload VolumeDTO pVolumeDTO, @Header( AmqpHeaders.RECEIVED_ROUTING_KEY ) String pKey ) throws InterruptedException
	{
		theVolumeChangeService.handleNewChange( pVolumeDTO );
	}
}
