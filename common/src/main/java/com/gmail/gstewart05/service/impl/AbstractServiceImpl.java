package com.gmail.gstewart05.service.impl;

import com.gmail.gstewart05.model.AbstractEntity;
import com.gmail.gstewart05.service.AbstractService;
import com.gmail.gstewart05.utils.LogUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public abstract class AbstractServiceImpl< T extends AbstractEntity > implements AbstractService< T >
{
	public abstract CrudRepository< T, String > getRepository();

	@Autowired
	private LogUtil theLogUtil;

	@Override
	public List< T > getAll()
	{
		return Lists.newArrayList( getRepository().findAll() );
	}

	@Override
	public T getById( String pID )
	{
		return getRepository().findOne( pID );
	}

	@Override
	public void delete( T pEntity )
	{
		getRepository().delete( pEntity );
	}

	@Override
	public void delete( String pID )
	{
		getRepository().delete( pID );
	}

	@Override
	public T save( T pEntity )
	{
		return getRepository().save( pEntity );
	}
}
