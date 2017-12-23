package com.gmail.gstewart05.deviceservice.cooler.model.devices;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanActuator;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
public class Cooler extends AbstractBooleanActuator
{
	@Builder
	public Cooler( String id, String name, boolean enabled, boolean enableRequested )
	{
		super( id, name, enabled, enableRequested );
	}
}
