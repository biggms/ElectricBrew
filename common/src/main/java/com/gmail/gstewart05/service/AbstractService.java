package com.gmail.gstewart05.service;

import com.gmail.gstewart05.model.AbstractEntity;

import java.util.List;

public interface AbstractService< T extends AbstractEntity >
{
	List< T > getAll();

	T getById( String pID );

	void delete( T pEntity );

	void delete( String pID );

	T save( T pEntity );
}
