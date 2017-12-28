package com.gmail.gstewart05.deviceservice.bubbler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.dto.BaseDTO;
import com.gmail.gstewart05.dto.BubblerDTO;
import com.gmail.gstewart05.model.DoubleMutator;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.OnOffMutator;
import com.gmail.gstewart05.model.OnOffSensor;
import com.gmail.gstewart05.model.wrappers.DoubleMutatorWrapper;
import com.gmail.gstewart05.model.wrappers.OnOffMutatorWrapper;
import com.gmail.gstewart05.model.wrappers.OnOffSensorWrapper;
import com.gmail.gstewart05.service.changelisteners.OnOffSensorListener;
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
@EntityListeners( OnOffSensorListener.class )
public class Bubbler extends NamedEntity implements OnOffSensorWrapper< BubblerDTO >
{
	@Embedded
	@Audited
	@JsonIgnore
	OnOffSensor onoffsensor;

	@PrePersist
	public void prePersist()
	{
		if( onoffsensor == null )
		{
			onoffsensor = new OnOffMutator();
		}
	}

	@Builder
	Bubbler( String id, String name )
	{
		super( id, name );
	}

	@Override
	public OnOffSensor getEmbeddedOnOff()
	{
		return onoffsensor;
	}

	@Override
	public Logger getLog()
	{
		return log;
	}

	@Override
	public Class< BubblerDTO > getDTOClass()
	{
		return BubblerDTO.class;
	}
}
