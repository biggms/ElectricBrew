package com.gmail.gstewart05.deviceservice.heater.model.devices;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanActuator;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
public class Heater extends AbstractBooleanActuator
{
	@Builder
	public Heater( String id, String name, boolean enabled, boolean enableRequested )
	{
		super( id, name, enabled, enableRequested);
	}
}
