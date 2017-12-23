package com.gmail.gstewart05.deviceservice.heatingelement.model.change;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractBooleanDeviceChange;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Accessors( chain = true )
@NoArgsConstructor
@Data
@ToString( callSuper = true )
public class HeatingElementChange extends AbstractBooleanDeviceChange< HeatingElement >
{
	@Builder
	HeatingElementChange( String id, HeatingElement device, Date createDate, boolean enabled )
	{
		super( id, device, createDate, enabled );
	}
}
