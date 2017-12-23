package com.gmail.gstewart05;

import org.springframework.amqp.support.converter.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config
{
	@Bean
	public Converter converter()
	{
		return new Converter();
	}
}
