package com.gmail.gstewart05.model.wrappers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.model.DoubleSensor;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.utils.LogUtil;
import org.slf4j.Logger;

public interface DoubleSensorWrapper< T extends DoubleDTO >
{
	@JsonIgnore
	DoubleSensor getEmbeddedDouble();

	@JsonIgnore
	NamedEntity getNamedEntity();

	@JsonIgnore
	LogUtil getLogUtil();

	@JsonIgnore
	Logger getLog();

	@JsonIgnore
	Class< T > getDTOClass();

	default double getValue()
	{
		return getEmbeddedDouble().getValue();
	}

	default void setValue( double pValue )
	{
		getEmbeddedDouble().setValue( pValue );
	}
}
