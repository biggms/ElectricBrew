package com.gmail.gstewart05.service.wrappers;

import com.gmail.gstewart05.dto.BaseDTO;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.wrappers.DoubleSensorWrapper;
import com.gmail.gstewart05.model.wrappers.OnOffSensorWrapper;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.stereotype.Service;

@Service
public interface OnOffServiceImpl< T extends NamedEntity & OnOffSensorWrapper, U extends BaseDTO & BooleanDTO >
{
	NamedService< T > getService();
	LogUtil getLogUtil();
	U getDTO();

	default void handleNewStateChange( U pDTO )
	{
		T lEntity = getService().getByName( pDTO.getName() );
		if( lEntity == null )
		{
			getLogUtil().warn( "Unknown {0}: {1}", getService().getSimpleName(), pDTO.getName() );
			return;
		}

		if( pDTO.isEnabled() == lEntity.isEnabled() )
		{
			return;
		}

		lEntity.setEnabled( pDTO.isEnabled() );
		getService().save( lEntity );

		getLogUtil().trace( "{0} - {1} Changed to: {2}", getService().getSimpleName(), lEntity.getName(), lEntity.isEnabled() );

		getDTO().stateChanged( lEntity.getName(), lEntity.isEnabled() );
	}
}
