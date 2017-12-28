package com.gmail.gstewart05.deviceservice.heater.service;

import com.gmail.gstewart05.deviceservice.heater.model.Heater;
import com.gmail.gstewart05.dto.HeaterDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.wrappers.DoubleSensorServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffMutatorServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;
import org.springframework.stereotype.Service;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public interface HeaterService extends NamedService< Heater >, OnOffMutatorServiceImpl< Heater, HeaterDTO >, DoubleSensorServiceImpl< Heater, HeaterDTO >
{
}
