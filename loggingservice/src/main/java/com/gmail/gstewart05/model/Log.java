package com.gmail.gstewart05.model;

import com.gmail.gstewart05.utils.Level;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Log
{
	@Id
	@Column( nullable = false )
	@GeneratedValue( generator = "uuid" )
	@GenericGenerator( name = "uuid", strategy = "uuid2" )
	String id;

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
}
