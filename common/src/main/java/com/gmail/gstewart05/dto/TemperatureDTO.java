package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class TemperatureDTO extends DoubleDTO
{
	String mac;

	@Override
	public String getRoute()
	{
		return "temperature.v1";
	}

	@Override
	public void setValue( String pName, double pValue )
	{
		throw new UnsupportedOperationException();
	}
}
