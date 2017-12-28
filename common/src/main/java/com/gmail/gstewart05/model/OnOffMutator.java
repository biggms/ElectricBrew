package com.gmail.gstewart05.model;

import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.PostPersist;

@Data
@NoArgsConstructor
@Audited
@Embeddable
public class OnOffMutator extends OnOffSensor
{
	@Audited
	@Column( nullable = false )
	@NonNull
	boolean enableRequested;
}
