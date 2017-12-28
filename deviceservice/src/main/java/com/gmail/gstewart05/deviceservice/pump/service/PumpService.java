package com.gmail.gstewart05.deviceservice.pump.service;

import com.gmail.gstewart05.deviceservice.pump.model.Pump;
import com.gmail.gstewart05.dto.PumpDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.wrappers.DoubleSensorServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;

public interface PumpService extends NamedService< Pump >, OnOffServiceImpl< Pump, PumpDTO >, DoubleSensorServiceImpl< Pump, PumpDTO >
{
}
