package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gmail.gstewart05.utils.Level;
import lombok.*;

import java.text.MessageFormat;
import java.util.Date;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true )
public class LogDTO
{
	String message;
	String level;
	Date createDate;

	public void setLevel( Level pLevel )
	{
		level = pLevel.toString();
	}
}
