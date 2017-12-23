package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class FlowDTO extends BooleanDTO
{
	@Override
	public String getRoute()
	{
		return "flow.v1";
	}

	@Override
	public void setState( String pName, boolean pState )
	{
		throw new UnsupportedOperationException();
	}
}
