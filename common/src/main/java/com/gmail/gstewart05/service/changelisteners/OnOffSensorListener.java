package com.gmail.gstewart05.service.changelisteners;

import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.model.wrappers.DoubleSensorWrapper;
import com.gmail.gstewart05.model.wrappers.OnOffSensorWrapper;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
@Slf4j
public class OnOffSensorListener
{
	static private DTOFactory theDTOFactory;
	static private LogUtil theLogUtil;

	@PostPersist
	@PostUpdate
	public void post( OnOffSensorWrapper pEntity )
	{
		theLogUtil.trace( "{0} - {1} Changed to: {2}", pEntity.getNamedEntity().getClass().getSimpleName(), pEntity.getNamedEntity().getName(), pEntity.isEnabled() );
		(( BooleanDTO ) theDTOFactory.getDTO( pEntity.getDTOClass() )).stateChanged( pEntity.getNamedEntity().getName(), pEntity.isEnabled() );
	}

	@Autowired
	public void init( DTOFactory pDTOFactory, LogUtil pLogUtil )
	{
		OnOffSensorListener.theDTOFactory = pDTOFactory;
		OnOffSensorListener.theLogUtil = pLogUtil;
	}
}
