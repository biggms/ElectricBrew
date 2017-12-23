package com.gmail.gstewart05.deviceservice.temperature.model.change;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractDoubleDeviceChange;
import com.gmail.gstewart05.deviceservice.temperature.model.devices.TemperatureProbe;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
public class TemperatureChange extends AbstractDoubleDeviceChange< TemperatureProbe >
{
	@Builder
	protected TemperatureChange( String id, TemperatureProbe device, Date createDate, double value )
	{
		super( id, device, createDate, value );
	}
}
