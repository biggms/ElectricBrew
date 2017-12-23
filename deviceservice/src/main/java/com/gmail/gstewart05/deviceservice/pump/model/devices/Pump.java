package com.gmail.gstewart05.deviceservice.pump.model.devices;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanActuator;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
public class Pump extends AbstractBooleanActuator
{
	@Builder
	public Pump( String id, String name, boolean enabled, boolean enableRequested )
	{
		super( id, name, enabled, enableRequested);
	}
}
