package com.gmail.gstewart05.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Embeddable
public class DoubleSensor
{
	@Audited
	@Column( nullable = false )
	@NonNull
	double value;
}
