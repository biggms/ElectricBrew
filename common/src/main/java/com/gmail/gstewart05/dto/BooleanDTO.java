package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface BooleanDTO< T extends BaseDTO & BooleanDTO >
{
	@JsonIgnore
	T getCurrentInstance();

	void setEnabled( boolean pEnabled );
	boolean isEnabled();

	default void stateChanged( String pName, boolean pState )
	{
		T lNew = getCurrentInstance();
		lNew.setName( pName );
		lNew.setEnabled( pState );
		lNew.getTemplate().convertAndSend( lNew.getExchange().getName(), lNew.getRoute() + ".statechanged", this );
	}

	default void setState( String pName, boolean pState )
	{
		T lNew = getCurrentInstance();
		lNew.setName( pName );
		lNew.setEnabled( pState );
		lNew.getTemplate().convertAndSend( lNew.getExchange().getName(), lNew.getRoute() + ".setstate", this );
	}
}
