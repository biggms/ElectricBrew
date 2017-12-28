package com.gmail.gstewart05.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Audited
@Embeddable
@MappedSuperclass
public class OnOffSensor
{
	@Audited
	@Column( nullable = false )
	@NonNull
	boolean enabled;
}
