package com.gmail.gstewart05.hotwaterservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.dto.HotWaterDTO;
import com.gmail.gstewart05.model.DoubleMutator;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.OnOffMutator;
import com.gmail.gstewart05.model.wrappers.DoubleMutatorWrapper;
import com.gmail.gstewart05.model.wrappers.OnOffMutatorWrapper;
import com.gmail.gstewart05.service.changelisteners.DoubleSensorListener;
import com.gmail.gstewart05.service.changelisteners.OnOffSensorListener;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.slf4j.Logger;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
@Slf4j
@Audited
@EntityListeners( {DoubleSensorListener.class, OnOffSensorListener.class} )
public class HotWater extends NamedEntity implements OnOffMutatorWrapper< HotWaterDTO >, DoubleMutatorWrapper< HotWaterDTO >
{
	@NotAudited
	@Column( nullable = false )
	@NonNull
	String temperatureProbe;

	@NotAudited
	@ElementCollection
	@Column( nullable = false )
	@NonNull
	List< String > heater;

	@NotAudited
	@Column( nullable = false )
	@NonNull
	String level;

	@NotAudited
	@Column( nullable = false )
	@NonNull
	String pump;

	@Embedded
	@Audited
	@JsonIgnore
	OnOffMutator onoffmutator;

	@Embedded
	@Audited
	@JsonIgnore
	DoubleMutator dutymutator;

	@Builder
	HotWater( String id, String name, String temperatureprobe, String heater, String level, String pump )
	{
		super( id, name );
		setTemperatureProbe( temperatureprobe );
		this.heater = new ArrayList< String >();
		this.heater.add( heater );
		setLevel( level );
		setPump( pump );
	}

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
	public Class< HotWaterDTO > getDTOClass()
	{
		return HotWaterDTO.class;
	}

	@Override
	public DoubleMutator getEmbeddedDouble()
	{
		return dutymutator;
	}

	@Override
	public OnOffMutator getEmbeddedOnOff()
	{
		return onoffmutator;
	}
}
