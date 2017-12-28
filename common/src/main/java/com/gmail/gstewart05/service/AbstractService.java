package com.gmail.gstewart05.service;

import com.gmail.gstewart05.model.BaseEntity;
import org.springframework.data.history.Revision;

import java.util.List;

public interface AbstractService< T extends BaseEntity >
{
	List< T > getAll();

	T getById( String pID );

	void delete( T pEntity );

	void delete( String pID );

	T save( T pEntity );

	String getSimpleName();

	List< Revision< Integer, T > > getAllRevisions( String pID );
}
