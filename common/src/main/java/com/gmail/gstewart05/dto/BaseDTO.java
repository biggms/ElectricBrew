package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Data
@JsonInclude( JsonInclude.Include.NON_NULL)
public abstract class BaseDTO
{
	@JsonIgnore
	public abstract String getRoute();
	String id;
	String name;

	@JsonIgnore
	RabbitTemplate template;
	@JsonIgnore
	TopicExchange exchange = new TopicExchange( "amq.topic" );
}
