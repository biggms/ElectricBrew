package com.gmail.gstewart05.deviceservice.common.model.change;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.deviceservice.common.model.devices.AbstractDevice;
import com.gmail.gstewart05.model.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Data
@NoArgsConstructor
public class AbstractDeviceChange< T extends AbstractDevice > extends AbstractEntity
{
	@JsonIgnore
	@ManyToOne( cascade = CascadeType.ALL, targetEntity = AbstractDevice.class )
	T device;

	@Column( nullable = false )
	@NonNull
	@CreationTimestamp
	@Temporal( TemporalType.TIMESTAMP )
	Date createDate;

	protected AbstractDeviceChange( String id, T device, Date createDate )
	{
		super( id );
		setDevice( device );
		setCreateDate( createDate );
	}
}
