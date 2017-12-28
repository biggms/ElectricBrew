package com.gmail.gstewart05.service.changelisteners;

import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.model.wrappers.DoubleMutatorWrapper;
import com.gmail.gstewart05.model.wrappers.DoubleSensorWrapper;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
@Slf4j
public class DoubleSensorListener
{
	static private DTOFactory theDTOFactory;
	static private LogUtil theLogUtil;

	@PostPersist
	@PostUpdate
	public void post( DoubleSensorWrapper pEntity )
	{
		theLogUtil.trace( "{0} - {1} Changed to: {2}", pEntity.getNamedEntity().getClass().getSimpleName(), pEntity.getNamedEntity().getName(), pEntity.getValue() );
		(( DoubleDTO ) theDTOFactory.getDTO( pEntity.getDTOClass() )).valueChanged( pEntity.getNamedEntity().getName(), pEntity.getValue() );
	}

	@Autowired
	public void init( DTOFactory pDTOFactory, LogUtil pLogUtil )
	{
		DoubleSensorListener.theDTOFactory = pDTOFactory;
		DoubleSensorListener.theLogUtil = pLogUtil;
	}
}
