package com.gmail.gstewart05.deviceservice.bubbler.model.change;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractBooleanDeviceChange;
import com.gmail.gstewart05.deviceservice.bubbler.model.devices.Bubbler;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
public class BubblerChange extends AbstractBooleanDeviceChange< Bubbler >
{
	@Builder
	BubblerChange( String id, Bubbler device, Date createDate, boolean enabled )
	{
		super( id, device, createDate, enabled );
	}
}
