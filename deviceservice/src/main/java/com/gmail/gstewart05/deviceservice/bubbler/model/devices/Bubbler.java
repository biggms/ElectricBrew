package com.gmail.gstewart05.deviceservice.bubbler.model.devices;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractBooleanDevice;
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
public class Bubbler extends AbstractBooleanDevice
{
	@Builder
	public Bubbler( String id, String name, boolean enabled )
	{
		super( id, name, enabled );
	}
}
