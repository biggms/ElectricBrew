package com.gmail.gstewart05.deviceservice.temperature.model.devices;

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
public class Temperature extends AbstractDoubleDevice
{
	@Column( nullable = false, unique = true )
	@NonNull
	String mac;

	@Builder
	Temperature( String id, String name, double currentValue, String mac )
	{
		super( id, name, currentValue );
		setMac( mac );
	}
}
