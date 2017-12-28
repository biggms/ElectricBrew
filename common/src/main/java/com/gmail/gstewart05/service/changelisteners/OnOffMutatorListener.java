package com.gmail.gstewart05.service.changelisteners;

import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.model.wrappers.OnOffMutatorWrapper;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
@Slf4j
public class OnOffMutatorListener
{
	static private DTOFactory theDTOFactory;
	static private LogUtil theLogUtil;

	@PostPersist
	@PostUpdate
	public void post( OnOffMutatorWrapper pEntity )
	{
		try
		{
			if( pEntity.isEnabled() != pEntity.isEnableRequested() )
			{
				theLogUtil.trace( "{0} - {1} - States don't match - setting to {2}", pEntity.getNamedEntity().getClass().getSimpleName(), pEntity.getNamedEntity().getName(), pEntity.isEnableRequested() );
				(( BooleanDTO ) theDTOFactory.getDTO( pEntity.getDTOClass() )).setState( pEntity.getNamedEntity().getName(), pEntity.isEnableRequested() );
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
		OnOffMutatorListener.theDTOFactory = pDTOFactory;
		OnOffMutatorListener.theLogUtil = pLogUtil;
	}
}
