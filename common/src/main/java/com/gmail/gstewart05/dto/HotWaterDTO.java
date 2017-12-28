package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class HotWaterDTO extends BaseDTO implements BooleanDTO< HotWaterDTO >, DoubleDTO< HotWaterDTO >
{
	double value;
	boolean enabled;

	@Override
	public String getRoute()
	{
		return "hotwater.v1";
	}

	public void enablePump( String pName )
	{
		setPumpState( pName, true );
	}

	public void disablePump( String pName )
	{
		setPumpState( pName, false );
	}

	public void setTarget( String pName, double pTarget )
	{
		name = pName;
		value = pTarget;
		template.convertAndSend( exchange.getName(), getRoute() + ".settarget", this );
	}

	public void setPumpState( String pName, boolean pPumpState )
	{
		name = pName;
		enabled = pPumpState;
		template.convertAndSend( exchange.getName(), getRoute() + ".setpumpstate", this );
	}

	@Override
	public HotWaterDTO getCurrentInstance()
	{
		return this;
	}
}
