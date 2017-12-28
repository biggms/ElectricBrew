package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class HeaterDTO extends BaseDTO implements BooleanDTO, DoubleDTO
{
	boolean enabled;
	double value;

	@Override
	public String getRoute()
	{
		return "heater.v1";
	}

	@Override
	public HeaterDTO getCurrentInstance()
	{
		return this;
	}
}
