package com.gmail.gstewart05.model;

import com.gmail.gstewart05.utils.Level;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.slf4j.Logger;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Log extends BaseEntity
{
	@Column( nullable = false )
	@NonNull
	Level level;

	@Column( nullable = false )
	@NonNull
	@CreationTimestamp
	@Temporal( TemporalType.TIMESTAMP )
	Date createDate;

	@Column( nullable = false )
	@NonNull
	String message;

	@Override
	public Logger getLog()
	{
		return log;
	}
}
