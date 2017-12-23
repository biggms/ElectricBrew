package com.gmail.gstewart05.deviceservice.cooler.model.change;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractBooleanDeviceChange;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
public class CoolerChange extends AbstractBooleanDeviceChange< Cooler >
{
	@Builder
	CoolerChange( String id, Cooler device, Date createDate, boolean enabled )
	{
		super( id, device, createDate, enabled );
	}
}
