package com.gmail.gstewart05.dto;

import com.gmail.gstewart05.model.BaseEntity;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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

	public HotWaterDTO getHotWaterDTO()
	{
		HotWaterDTO lHotWaterDTO = new HotWaterDTO();
		lHotWaterDTO.setTemplate( theTemplate );
		lHotWaterDTO.setExchange( theExchange );
		return lHotWaterDTO;
	}

	public LevelDTO getLevelDTO()
	{
		LevelDTO lLevelDTO = new LevelDTO();
		lLevelDTO.setTemplate( theTemplate );
		lLevelDTO.setExchange( theExchange );
		return lLevelDTO;
	}

	public LogDTO getLogDTO()
	{
		LogDTO lLogDTO = new LogDTO();
		lLogDTO.setTemplate( theTemplate );
		lLogDTO.setExchange( theExchange );
		return lLogDTO;
	}

	public PumpDTO getPumpDTO()
	{
		PumpDTO lPumpDTO = new PumpDTO();
		lPumpDTO.setTemplate( theTemplate );
		lPumpDTO.setExchange( theExchange );
		return lPumpDTO;
	}

	public TemperatureDTO getTemperatureDTO()
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

	public VolumeDTO getVolumeDTO()
	{
		VolumeDTO lVolumeDTO = new VolumeDTO();
		lVolumeDTO.setTemplate( theTemplate );
		lVolumeDTO.setExchange( theExchange );
		return lVolumeDTO;
	}

	public BaseDTO getDTO( Class< ? extends BaseDTO > pClass )
	{
		if( pClass.isAssignableFrom( BubblerDTO.class ) )
		{
			return getBubblerDTO();
		}
		else if( pClass.isAssignableFrom( CoolerDTO.class ) )
		{
			return getCoolerDTO();
		}
		else if( pClass.isAssignableFrom( FlowDTO.class ) )
		{
			return getFlowDTO();
		}
		else if( pClass.isAssignableFrom( HeaterDTO.class ) )
		{
			return getHeaterDTO();
		}
		else if( pClass.isAssignableFrom( HotWaterDTO.class ) )
		{
			return getHotWaterDTO();
		}
		else if( pClass.isAssignableFrom( LevelDTO.class ) )
		{
			return getLevelDTO();
		}
		else if( pClass.isAssignableFrom( LogDTO.class ) )
		{
			return getLogDTO();
		}
		else if( pClass.isAssignableFrom( PumpDTO.class ) )
		{
			return getPumpDTO();
		}
		else if( pClass.isAssignableFrom( TemperatureDTO.class ) )
		{
			return getTemperatureDTO();
		}
		else if( pClass.isAssignableFrom( ValveDTO.class ) )
		{
			return getValveDTO();
		}
		else if( pClass.isAssignableFrom( VolumeDTO.class ) )
		{
			return getVolumeDTO();
		}

		return null;
	}
}
