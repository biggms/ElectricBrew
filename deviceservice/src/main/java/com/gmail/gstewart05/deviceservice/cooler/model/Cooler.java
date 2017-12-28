package com.gmail.gstewart05.deviceservice.cooler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.dto.CoolerDTO;
import com.gmail.gstewart05.model.DoubleMutator;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.OnOffMutator;
import com.gmail.gstewart05.model.wrappers.DoubleMutatorWrapper;
import com.gmail.gstewart05.model.wrappers.OnOffMutatorWrapper;
import com.gmail.gstewart05.service.changelisteners.DoubleMutatorListener;
import com.gmail.gstewart05.service.changelisteners.OnOffMutatorListener;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.Audited;
import org.slf4j.Logger;

import javax.persistence.*;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
@Audited
@Slf4j
@EntityListeners( {OnOffMutatorListener.class, DoubleMutatorListener.class} )
public class Cooler extends NamedEntity implements OnOffMutatorWrapper< CoolerDTO >, DoubleMutatorWrapper< CoolerDTO >
{
	@Embedded
	@Audited
	@JsonIgnore
	OnOffMutator onoffmutator;

	@Embedded
	@Audited
	@JsonIgnore
	DoubleMutator dutymutator;

	@PrePersist
	public void prePersist()
	{
		if( onoffmutator == null )
		{
			onoffmutator = new OnOffMutator();
		}
		if( dutymutator == null )
		{
			dutymutator = new DoubleMutator();
		}
	}

	@Override
	public Logger getLog()
	{
		return log;
	}

	@Override
	public Class< CoolerDTO > getDTOClass()
	{
		return CoolerDTO.class;
	}

	@Builder
	Cooler( String id, String name )
	{
		super( id, name );
	}

	@Override
	public OnOffMutator getEmbeddedOnOff()
	{
		return onoffmutator;
	}

	@Override
	public DoubleMutator getEmbeddedDouble()
	{
		return dutymutator;
	}
}
