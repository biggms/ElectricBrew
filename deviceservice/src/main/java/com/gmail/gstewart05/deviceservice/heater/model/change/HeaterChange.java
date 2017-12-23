package com.gmail.gstewart05.deviceservice.heater.model.change;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractBooleanDeviceChange;
import com.gmail.gstewart05.deviceservice.heater.model.devices.Heater;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
public class HeaterChange extends AbstractBooleanDeviceChange< Heater >
{
	@Builder
	HeaterChange( String id, Heater device, Date createDate, boolean enabled )
	{
		super( id, device, createDate, enabled );
	}
}
