package com.gmail.gstewart05.model.wrappers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.model.DoubleSensor;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.OnOffSensor;
import com.gmail.gstewart05.utils.LogUtil;
import org.slf4j.Logger;

public interface OnOffSensorWrapper< T extends BooleanDTO >
{
	@JsonIgnore
	OnOffSensor getEmbeddedOnOff();

	@JsonIgnore
	NamedEntity getNamedEntity();

	@JsonIgnore
	LogUtil getLogUtil();

	@JsonIgnore
	Logger getLog();

	@JsonIgnore
	Class< T > getDTOClass();

	default boolean isEnabled()
	{
		return getEmbeddedOnOff().isEnabled();
	}

	default void setEnabled( boolean pEnabled )
	{
		getEmbeddedOnOff().setEnabled( pEnabled );
	}
}
