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
public abstract class AbstractDoubleDevice extends AbstractDevice
{
	@Column( nullable = false )
	@NonNull
	double currentValue;

	protected AbstractDoubleDevice( String id, String name, double currentValue )
	{
		super( id, name );
		setCurrentValue( currentValue );
	}
}
