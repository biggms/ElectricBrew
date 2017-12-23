package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@ToString( callSuper = true )
public class LevelDTO extends BooleanDTO
{
	@Override
	public String getRoute()
	{
		return "level.v1";
	}
}
