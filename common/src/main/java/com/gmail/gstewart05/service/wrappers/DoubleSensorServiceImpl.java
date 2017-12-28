package com.gmail.gstewart05.service.wrappers;

import com.gmail.gstewart05.dto.BaseDTO;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.wrappers.DoubleSensorWrapper;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.stereotype.Service;

@Service

public interface DoubleSensorServiceImpl< T extends NamedEntity & DoubleSensorWrapper, U extends BaseDTO & DoubleDTO >
{
	NamedService< T > getService();
	LogUtil getLogUtil();
	U getDTO();

	default void handleNewValueChange( U pDTO )
	{
		T lEntity = getService().getByName( pDTO.getName() );
		if( lEntity == null )
		{
			getLogUtil().warn( "Unknown {0}: {1}", getService().getSimpleName(), pDTO.getName() );
			return;
		}

		if( pDTO.getValue() == lEntity.getValue() )
		{
			return;
		}

		lEntity.setValue( pDTO.getValue() );
		getService().save( lEntity );
	}
}
