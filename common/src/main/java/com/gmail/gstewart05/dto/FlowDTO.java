package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class FlowDTO extends BaseDTO implements BooleanDTO< FlowDTO >
{
	boolean enabled;

	@Override
	public String getRoute()
	{
		return "flow.v1";
	}

	@Override
	public FlowDTO getCurrentInstance()
	{
		return this;
	}

	@Override
	public void setState( String pName, boolean pState )
	{
		throw new UnsupportedOperationException();
	}
}
