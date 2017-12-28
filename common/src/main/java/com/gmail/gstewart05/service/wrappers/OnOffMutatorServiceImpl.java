package com.gmail.gstewart05.service.wrappers;

import com.gmail.gstewart05.dto.BaseDTO;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.model.NamedEntity;
import com.gmail.gstewart05.model.wrappers.OnOffMutatorWrapper;
import com.gmail.gstewart05.model.wrappers.OnOffSensorWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public interface OnOffMutatorServiceImpl< T extends NamedEntity & OnOffMutatorWrapper, U extends BaseDTO & BooleanDTO > extends OnOffServiceImpl< T, U >
{
}
