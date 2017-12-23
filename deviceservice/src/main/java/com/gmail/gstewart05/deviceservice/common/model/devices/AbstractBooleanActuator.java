package com.gmail.gstewart05.deviceservice.common.model.devices;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Data
@NoArgsConstructor
public abstract class AbstractBooleanActuator extends AbstractBooleanDevice
{
	@Column( nullable = false )
	@NonNull
	boolean enableRequested;

	protected AbstractBooleanActuator( String id, String name, boolean enabled, boolean enableRequested )
	{
		super( id, name, enabled );
		setEnableRequested( enableRequested );
	}
}
