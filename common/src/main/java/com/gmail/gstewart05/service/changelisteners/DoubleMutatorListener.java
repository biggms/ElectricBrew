package com.gmail.gstewart05.service.changelisteners;

import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.model.wrappers.DoubleMutatorWrapper;
import com.gmail.gstewart05.model.wrappers.OnOffMutatorWrapper;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
@Slf4j
public class DoubleMutatorListener
{
	static private DTOFactory theDTOFactory;
	static private LogUtil theLogUtil;

	@PostPersist
	@PostUpdate
	public void post( DoubleMutatorWrapper pEntity )
	{
		try
		{
			if( pEntity.getValue() != pEntity.getValueRequested() )
			{
				log.info( "{} - Values don't match {} != {} - setting to {}", pEntity.getNamedEntity().getName(), pEntity.getValue(), pEntity.getValueRequested(), pEntity.getValueRequested() );
				(( DoubleDTO ) theDTOFactory.getDTO( pEntity.getDTOClass() )).setValue( pEntity.getNamedEntity().getName(), pEntity.getValueRequested() );
			}
		}
		catch( Exception e )
		{
			log.error( "WYT: ", e );
		}
	}

	@Autowired
	public void init( DTOFactory pDTOFactory, LogUtil pLogUtil )
	{
		DoubleMutatorListener.theDTOFactory = pDTOFactory;
		DoubleMutatorListener.theLogUtil = pLogUtil;
	}
}
