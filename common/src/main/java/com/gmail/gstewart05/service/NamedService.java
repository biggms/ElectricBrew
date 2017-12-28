package com.gmail.gstewart05.service;

import com.gmail.gstewart05.model.NamedEntity;

public interface NamedService< T extends NamedEntity > extends AbstractService< T >
{
	T getByName( String pName );
}
