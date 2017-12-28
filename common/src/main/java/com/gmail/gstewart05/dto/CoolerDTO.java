package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class CoolerDTO extends BaseDTO implements BooleanDTO< CoolerDTO >, DoubleDTO< CoolerDTO >
{
	boolean enabled;
	double value;

	@Override
	public String getRoute()
	{
		return "cooler.v1";
	}

	@Override
	public CoolerDTO getCurrentInstance()
	{
		return this;
	}
}
