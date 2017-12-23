package com.gmail.gstewart05.deviceservice.volume.model.change;

import com.gmail.gstewart05.deviceservice.common.model.change.AbstractDoubleDeviceChange;
import com.gmail.gstewart05.deviceservice.volume.model.devices.Volume;
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
public class VolumeChange extends AbstractDoubleDeviceChange< Volume >
{
	@Builder
	protected VolumeChange( String id, Volume device, Date createDate, double value )
	{
		super( id, device, createDate, value );
	}
}
