package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class VolumeDTO extends DoubleDTO
{
	@Override
	public String getRoute()
	{
		return "volume.v1";
	}

	@Override
	public void setValue( String pName, double pValue )
	{
		throw new UnsupportedOperationException();
	}
}
