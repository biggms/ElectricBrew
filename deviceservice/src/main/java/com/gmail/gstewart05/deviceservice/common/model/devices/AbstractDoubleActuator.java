package com.gmail.gstewart05.deviceservice.common.model.devices;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Data
@NoArgsConstructor
public abstract class AbstractDoubleActuator extends AbstractDoubleDevice
{
	@Column( nullable = false )
	@NonNull
	double requestedValue;

	protected AbstractDoubleActuator( String id, String name, double currentValue, double requestedValue )
	{
		super( id, name, currentValue );
		setRequestedValue( requestedValue );
	}
}
