package com.gmail.gstewart05.deviceservice.valve.service;

import com.gmail.gstewart05.deviceservice.valve.model.Valve;
import com.gmail.gstewart05.dto.ValveDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;

public interface ValveService extends NamedService< Valve >, OnOffServiceImpl< Valve, ValveDTO >
{
}
