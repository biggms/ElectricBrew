package com.gmail.gstewart05.deviceservice.common.model.devices;

import com.gmail.gstewart05.model.AbstractEntity;
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
public abstract class AbstractDevice extends AbstractEntity
{
	@Column( nullable = false, unique = true )
	@NonNull
	String name;

	AbstractDevice( String id, String name )
	{
		super( id );
		setName( name );
	}
}
