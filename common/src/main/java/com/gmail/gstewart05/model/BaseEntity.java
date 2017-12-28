package com.gmail.gstewart05.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Data
@NoArgsConstructor
@Audited
public abstract class BaseEntity
{
	@Autowired
	@JsonIgnore
	@Transient
	LogUtil logUtil;

	@NotAudited
	@Id
	@Column( nullable = false )
	@GeneratedValue( generator = "uuid" )
	@GenericGenerator( name = "uuid", strategy = "uuid2" )
	String id;

	BaseEntity( String id )
	{
		this.id = id;
	}

	@JsonIgnore
	@Transient
	public abstract Logger getLog();
}
