package com.gmail.gstewart05.model.wrappers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.model.DoubleMutator;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.utils.LogUtil;
import org.slf4j.Logger;

public interface DoubleMutatorWrapper< T extends DoubleDTO > extends DoubleSensorWrapper< T >
{
	@Override
	@JsonIgnore
	DoubleMutator getEmbeddedDouble();

	default double getValueRequested()
	{
		return getEmbeddedDouble().getValueRequested();
	}

	default void setValueRequested( double pValueRequested )
	{
		getEmbeddedDouble().setValueRequested( pValueRequested );
	}
}
