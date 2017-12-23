package com.gmail.gstewart05.dto;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOFactory
{
	@Autowired
	private RabbitTemplate theTemplate;

	private TopicExchange theExchange = new TopicExchange( "amq.topic" );

	public BubblerDTO getBubblerDTO()
	{
		BubblerDTO lBubblerDTO = new BubblerDTO();
		lBubblerDTO.setTemplate( theTemplate );
		lBubblerDTO.setExchange( theExchange );
		return lBubblerDTO;
	}

	public CoolerDTO getCoolerDTO()
	{
		CoolerDTO lCoolerDTO = new CoolerDTO();
		lCoolerDTO.setTemplate( theTemplate );
		lCoolerDTO.setExchange( theExchange );
		return lCoolerDTO;
	}

	public FlowDTO getFlowDTO()
	{
		FlowDTO lFlowDTO = new FlowDTO();
		lFlowDTO.setTemplate( theTemplate );
		lFlowDTO.setExchange( theExchange );
		return lFlowDTO;
	}

	public HeaterDTO getHeaterDTO()
	{
		HeaterDTO lHeaterDTO = new HeaterDTO();
		lHeaterDTO.setTemplate( theTemplate );
		lHeaterDTO.setExchange( theExchange );
		return lHeaterDTO;
	}

	public LevelDTO getLevelDTO()
	{
		LevelDTO lLevelDTO = new LevelDTO();
		lLevelDTO.setTemplate( theTemplate );
		lLevelDTO.setExchange( theExchange );
		return lLevelDTO;
	}

	public PumpDTO getPumpDTO()
	{
		PumpDTO lPumpDTO = new PumpDTO();
		lPumpDTO.setTemplate( theTemplate );
		lPumpDTO.setExchange( theExchange );
		return lPumpDTO;
	}

	public TemperatureDTO getTemperatureProbeDTO()
	{
		TemperatureDTO lTemperatureDTO = new TemperatureDTO();
		lTemperatureDTO.setTemplate( theTemplate );
		lTemperatureDTO.setExchange( theExchange );
		return lTemperatureDTO;
	}

	public ValveDTO getValveDTO()
	{
		ValveDTO lValveDTO = new ValveDTO();
		lValveDTO.setTemplate( theTemplate );
		lValveDTO.setExchange( theExchange );
		return lValveDTO;
	}
}
