package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
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
