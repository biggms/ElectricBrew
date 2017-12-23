package com.gmail.gstewart05;

import com.gmail.gstewart05.deviceservice.bubbler.model.devices.Bubbler;
import com.gmail.gstewart05.deviceservice.bubbler.service.BubblerService;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerService;
import com.gmail.gstewart05.deviceservice.flow.model.devices.Flow;
import com.gmail.gstewart05.deviceservice.flow.service.FlowService;
import com.gmail.gstewart05.deviceservice.heater.model.devices.Heater;
import com.gmail.gstewart05.deviceservice.heater.service.HeaterService;
import com.gmail.gstewart05.deviceservice.level.model.devices.Level;
import com.gmail.gstewart05.deviceservice.level.service.LevelService;
import com.gmail.gstewart05.deviceservice.pump.model.devices.Pump;
import com.gmail.gstewart05.deviceservice.pump.service.PumpService;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureProbeService;
import com.gmail.gstewart05.deviceservice.valve.model.devices.Valve;
import com.gmail.gstewart05.deviceservice.valve.service.ValveService;
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
public class DeviceServer
{
	public static void main( String[] args )
	{
		SpringApplication.run( DeviceServer.class, args );
	}

	@Bean
	public CommandLineRunner demo( TemperatureProbeService pTemperatureProbeService, HeaterService pHeaterService, CoolerService pCoolerService, PumpService pPumpService, ValveService pValveService, LevelService pLevelService, FlowService pFlowService, BubblerService pBubblerService )
	{
		return ( args ) ->
		{
			TemperatureProbe lTemperatureProbe = TemperatureProbe.builder().name( "Cold Water" ).mac( "28ff220b00150208" ).build();
			pTemperatureProbeService.save( lTemperatureProbe );

			lTemperatureProbe = TemperatureProbe.builder().name( "Warm Water" ).mac( "28ff6a02641403ed" ).build();
			pTemperatureProbeService.save( lTemperatureProbe );

			lTemperatureProbe = TemperatureProbe.builder().name( "Fermenter" ).mac( "28ff983d6414031a" ).build();
			pTemperatureProbeService.save( lTemperatureProbe );

			Heater lHeater = Heater.builder().name( "Warm Water" ).build();
			pHeaterService.save( lHeater );

			lHeater = Heater.builder().name( "Boiler 1" ).build();
			pHeaterService.save( lHeater );

			lHeater = Heater.builder().name( "Boiler 2" ).build();
			pHeaterService.save( lHeater );

			Cooler lCooler = Cooler.builder().name( "Freezer" ).build();
			pCoolerService.save( lCooler );

			Pump lPump = Pump.builder().name( "Warm Water" ).build();
			pPumpService.save( lPump );

			lPump = Pump.builder().name( "Cold Water" ).build();
			pPumpService.save( lPump );

			lPump = Pump.builder().name( "Boiler" ).build();
			pPumpService.save( lPump );

			lPump = Pump.builder().name( "Agitator" ).build();
			pPumpService.save( lPump );

			Valve lValve = Valve.builder().name( "Warm Water Input" ).build();
			pValveService.save( lValve );

			lValve = Valve.builder().name( "Warm Water Output" ).build();
			pValveService.save( lValve );

			lValve = Valve.builder().name( "Cold Water Input" ).build();
			pValveService.save( lValve );

			lValve = Valve.builder().name( "Cold Water Output" ).build();
			pValveService.save( lValve );

			lValve = Valve.builder().name( "Mains Water Input" ).build();
			pValveService.save( lValve );

			lValve = Valve.builder().name( "Mains Water Output" ).build();
			pValveService.save( lValve );

			Level lLevel = Level.builder().name( "Warm Water" ).build();
			pLevelService.save( lLevel );

			lLevel = Level.builder().name( "Cold Water" ).build();
			pLevelService.save( lLevel );

			Flow lFlow = Flow.builder().name( "Warm Water" ).build();
			pFlowService.save( lFlow );

			lFlow = Flow.builder().name( "Cold Water" ).build();
			pFlowService.save( lFlow );

			lFlow = Flow.builder().name( "Boiler" ).build();
			pFlowService.save( lFlow );

			Bubbler lBubbler = Bubbler.builder().name( "Fermenter" ).build();
			pBubblerService.save( lBubbler );
		};
	}
}