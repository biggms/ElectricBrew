package com.gmail.gstewart05.deviceservice.temperature.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.dto.TemperatureDTO;
import com.gmail.gstewart05.model.DoubleSensor;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.wrappers.DoubleSensorWrapper;
import com.gmail.gstewart05.service.changelisteners.DoubleSensorListener;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.slf4j.Logger;

import javax.persistence.*;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
@Audited
@Slf4j
@EntityListeners( DoubleSensorListener.class )
public class Temperature extends NamedEntity implements DoubleSensorWrapper< TemperatureDTO >
{
	@NotAudited
	@Column( nullable = false, unique = true )
	@NonNull
	String mac;

	@Embedded
	@Audited
	@JsonIgnore
	DoubleSensor sensor;

	@PrePersist
	public void prePersist()
	{
		if( sensor == null )
		{
			sensor = new DoubleSensor();
		}
	}

	@Builder
	Temperature( String id, String name, String mac )
	{
		super( id, name );
		setMac( mac );
	}

	@Override
	public DoubleSensor getEmbeddedDouble()
	{
		return sensor;
	}

	@Override
	public Logger getLog()
	{
		return log;
	}

	@Override
	public Class< TemperatureDTO > getDTOClass()
	{
		return TemperatureDTO.class;
	}
}
