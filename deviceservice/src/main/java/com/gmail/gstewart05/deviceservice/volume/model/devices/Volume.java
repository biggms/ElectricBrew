package com.gmail.gstewart05.deviceservice.volume.model.devices;

import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDoubleDevice;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
public class Volume extends AbstractDoubleDevice
{
	@Builder
	Volume( String id, String name, double currentValue )
	{
		super( id, name, currentValue );
	}
}
