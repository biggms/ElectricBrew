package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Data
public abstract class DTO
{
	String name;

	@JsonIgnore
	RabbitTemplate template;
	@JsonIgnore
	TopicExchange exchange = new TopicExchange( "amq.topic" );
}
