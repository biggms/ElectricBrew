package com.gmail.gstewart05.deviceservice.common.model.change;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDoubleDevice;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Data
@NoArgsConstructor
public abstract class AbstractDoubleDeviceChange< T extends AbstractDoubleDevice > extends AbstractDeviceChange< T >
{
	@Column( nullable = false )
	@NonNull
	double value;

	protected AbstractDoubleDeviceChange( String id, T device, Date createDate, double value )
	{
		super( id, device, createDate );
		setValue( value );
	}
}
