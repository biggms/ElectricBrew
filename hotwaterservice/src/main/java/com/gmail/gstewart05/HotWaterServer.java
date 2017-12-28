package com.gmail.gstewart05;

import com.gmail.gstewart05.hotwaterservice.model.HotWater;
import com.gmail.gstewart05.hotwaterservice.service.HotWaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@Slf4j
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories( repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class )
public class HotWaterServer
{
	public static void main( String[] args )
	{
		SpringApplication.run( HotWaterServer.class, args );
	}

	@Bean
	public CommandLineRunner demo( HotWaterService pHotWaterService )
	{
		return ( args ) ->
		{
			HotWater lHotWater = HotWater.builder().name( "Hot Water 1" ).heater( "Warm Water" ).temperatureprobe( "Warm Water" ).pump( "Warm Water" ).level( "Warm Water" ).build();
			pHotWaterService.save( lHotWater );
		};
	}
}