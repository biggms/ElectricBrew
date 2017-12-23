package com.gmail.gstewart05.dto;

import lombok.Data;

@Data
public abstract class BooleanDTO extends DTO
{
	String id;
	boolean enabled;

	public abstract String getRoute();

	public void enable( String pName )
	{
		setState( pName, true );
	}

	public void disable( String pName )
	{
		setState( pName, false );
	}

	public void stateChanged( String pName, boolean pState )
	{
		name = pName;
		enabled = pState;
		template.convertAndSend( exchange.getName(), getRoute() + ".statechanged", this );
	}

	public void setState( String pName, boolean pState )
	{
		name = pName;
		enabled = pState;
		template.convertAndSend( exchange.getName(), getRoute() + ".setstate", this );
	}
}
