package com.gmail.gstewart05.deviceservice.heater.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.dto.HeaterDTO;
import com.gmail.gstewart05.model.DoubleMutator;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.OnOffMutator;
import com.gmail.gstewart05.model.wrappers.DoubleMutatorWrapper;
import com.gmail.gstewart05.model.wrappers.OnOffMutatorWrapper;
import com.gmail.gstewart05.service.changelisteners.DoubleMutatorListener;
import com.gmail.gstewart05.service.changelisteners.OnOffMutatorListener;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.Audited;
import org.slf4j.Logger;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.PrePersist;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
@Audited
@Slf4j
@EntityListeners( {OnOffMutatorListener.class, DoubleMutatorListener.class} )
public class Heater extends NamedEntity implements OnOffMutatorWrapper< HeaterDTO >, DoubleMutatorWrapper< HeaterDTO >
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

	@Builder
	Heater( String id, String name )
	{
		super( id, name );
	}

	@Override
	public OnOffMutator getEmbeddedOnOff()
	{
		return onoffmutator;
	}

	@Override
	public Logger getLog()
	{
		return log;
	}

	@Override
	public Class< HeaterDTO > getDTOClass()
	{
		return HeaterDTO.class;
	}

	@Override
	public DoubleMutator getEmbeddedDouble()
	{
		return dutymutator;
	}
}
