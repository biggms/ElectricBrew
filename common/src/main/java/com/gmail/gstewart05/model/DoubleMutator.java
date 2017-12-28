package com.gmail.gstewart05.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Audited
@Embeddable
public class DoubleMutator extends DoubleSensor
{
	@Audited
	@Column( nullable = false )
	@NonNull
	double valueRequested;
}
