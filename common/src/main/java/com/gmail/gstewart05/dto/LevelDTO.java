package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class LevelDTO extends BaseDTO implements BooleanDTO< LevelDTO >
{
	boolean enabled;

	@Override
	public String getRoute()
	{
		return "level.v1";
	}

	@Override
	public LevelDTO getCurrentInstance()
	{
		return this;
	}

	@Override
	public void setState( String pName, boolean pState )
	{
		throw new UnsupportedOperationException();
	}
}
