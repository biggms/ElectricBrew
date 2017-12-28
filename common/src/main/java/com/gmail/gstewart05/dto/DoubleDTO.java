package com.gmail.gstewart05.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface DoubleDTO< T extends BaseDTO & DoubleDTO >
{
	@JsonIgnore
	T getCurrentInstance();

	void setValue( double pValue );
	double getValue();

	default void valueChanged( String pName, double pValue )
	{
		T lNew = getCurrentInstance();
		lNew.setName( pName );
		lNew.setValue( pValue );
		lNew.getTemplate().convertAndSend( lNew.getExchange().getName(), lNew.getRoute() + ".valuechanged", this );
	}

	default void setValue( String pName, double pValue )
	{
		T lNew = getCurrentInstance();
		lNew.setName( pName );
		lNew.setValue( pValue );
		lNew.getTemplate().convertAndSend( lNew.getExchange().getName(), lNew.getRoute() + ".setvalue", this );
	}
}
