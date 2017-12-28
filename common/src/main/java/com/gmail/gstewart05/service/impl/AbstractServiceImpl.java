package com.gmail.gstewart05.service.impl;

import com.gmail.gstewart05.model.BaseEntity;
import com.gmail.gstewart05.model.repo.BaseEntityRepository;
import com.gmail.gstewart05.service.AbstractService;
import com.gmail.gstewart05.utils.LogUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public abstract class AbstractServiceImpl< T extends BaseEntity > implements AbstractService< T >
{
	public abstract BaseEntityRepository< T > getRepository();

	@Override
	public List< T > getAll()
	{
		return Lists.newArrayList( getRepository().findAll() );
	}

	@Override
	public T getById( String pID )
	{
		return getRepository().findById( pID ).get();
	}

	@Override
	public void delete( T pEntity )
	{
		getRepository().delete( pEntity );
	}

	@Override
	public void delete( String pID )
	{
		getRepository().delete( getById( pID ) );
	}

	@Override
	public T save( T pEntity )
	{
		return getRepository().save( pEntity );
	}

	@Override
	public List< Revision< Integer, T > > getAllRevisions( String pID )
	{
		return getRepository().findRevisions( pID ).getContent();
	}
}
