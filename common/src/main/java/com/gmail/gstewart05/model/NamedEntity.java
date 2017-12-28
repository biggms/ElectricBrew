package com.gmail.gstewart05.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Data
@NoArgsConstructor
@Audited
@ToString( callSuper = true )
@Slf4j
public abstract class NamedEntity extends BaseEntity
{
	@NotAudited
	@Column( nullable = false, unique = true )
	@NonNull
	String name;

	protected NamedEntity( String id, String name )
	{
		super( id );
		setName( name );
	}

	public NamedEntity getNamedEntity()
	{
		return this;
	}
}
