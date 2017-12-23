package com.gmail.gstewart05.dto;

import lombok.Data;

@Data
public abstract class DoubleDTO extends DTO
{
	String id;
	double value;

	public abstract String getRoute();

	public void valueChanged( String pName, double pValue )
	{
		name = pName;
		value = pValue;
		template.convertAndSend( exchange.getName(), getRoute() + ".valuechanged", this );
	}

	public void setValue( String pName, double pValue )
	{
		name = pName;
		value = pValue;
		template.convertAndSend( exchange.getName(), getRoute() + ".setvalue", this );
	}
}
