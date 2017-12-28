package com.gmail.gstewart05.model.wrappers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.dto.BaseDTO;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.model.DoubleMutator;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.OnOffMutator;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

import javax.persistence.PostPersist;

public interface OnOffMutatorWrapper< T extends BooleanDTO > extends OnOffSensorWrapper< T >
{
	@Override
	@JsonIgnore
	OnOffMutator getEmbeddedOnOff();

	default boolean isEnableRequested()
	{
		return getEmbeddedOnOff().isEnableRequested();
	}

	default void setEnableRequested( boolean pEnableRequested )
	{
		getEmbeddedOnOff().setEnableRequested( pEnableRequested );
	}
}
