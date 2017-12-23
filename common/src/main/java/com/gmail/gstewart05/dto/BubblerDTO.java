package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class BubblerDTO extends BooleanDTO
{
	@Override
	public String getRoute()
	{
		return "bubbler.v1";
	}

	@Override
	public void setState( String pName, boolean pState )
	{
		throw new UnsupportedOperationException();
	}
}
