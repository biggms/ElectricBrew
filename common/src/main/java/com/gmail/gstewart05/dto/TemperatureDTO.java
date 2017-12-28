package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class TemperatureDTO extends BaseDTO implements DoubleDTO< TemperatureDTO >
{
	double value;
	String mac;

	@Override
	public String getRoute()
	{
		return "temperature.v1";
	}

	@Override
	public TemperatureDTO getCurrentInstance()
	{
		return this;
	}

	@Override
	public void setValue( String pName, double pValue )
	{
		throw new UnsupportedOperationException();
	}
}
