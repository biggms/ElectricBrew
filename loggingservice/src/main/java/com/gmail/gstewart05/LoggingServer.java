package com.gmail.gstewart05;

import com.gmail.gstewart05.model.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@Slf4j
public class LoggingServer
{
	public static void main( String[] args )
	{
		SpringApplication.run( LoggingServer.class, args );
	}

	@Bean
	public CommandLineRunner demo( LogRepository pRepository )
	{
		return ( args ) ->
		{
		};
	}
}