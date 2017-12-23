package com.gmail.gstewart05.deviceservice.common.model.change;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanDevice;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Data
@NoArgsConstructor
public abstract class AbstractBooleanDeviceChange< T extends AbstractBooleanDevice > extends AbstractDeviceChange< T >
{
	@Column( nullable = false )
	@NonNull
	boolean enabled;

	protected AbstractBooleanDeviceChange( String id, T device, Date createDate, boolean enabled )
	{
		super( id, device, createDate );
		setEnabled( enabled );
	}
}
