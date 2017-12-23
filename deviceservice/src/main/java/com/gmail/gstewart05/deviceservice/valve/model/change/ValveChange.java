package com.gmail.gstewart05.deviceservice.valve.model.change;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractBooleanDeviceChange;
import com.gmail.gstewart05.deviceservice.valve.model.devices.Valve;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
public class ValveChange extends AbstractBooleanDeviceChange< Valve >
{
	@Builder
	ValveChange( String id, Valve device, Date createDate, boolean enabled )
	{
		super( id, device, createDate, enabled );
	}
}
