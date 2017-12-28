package com.gmail.gstewart05.service.impl;

import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class NamedServiceImpl< T extends NamedEntity > extends AbstractServiceImpl< T > implements NamedService< T >
{
	@Autowired
	private LogUtil theLogUtil;

	@Override
	public abstract NamedEntityRepository< T > getRepository();

	@Override
	public T getByName( String pName )
	{
		return getRepository().findByNameIgnoreCase( pName );
	}

	@Override
	public T save( T pEntity )
	{
		boolean lCreated = pEntity.getId() == null;
		pEntity = getRepository().save( pEntity );
		if( lCreated )
		{
			theLogUtil.info( "{0} created: {1}", getSimpleName(), pEntity.getName() );
		}
		return pEntity;
	}
}
