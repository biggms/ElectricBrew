package com.gmail.gstewart05.deviceservice.cooler.service;

import com.gmail.gstewart05.deviceservice.cooler.model.Cooler;
import com.gmail.gstewart05.dto.CoolerDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.wrappers.DoubleSensorServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;

public interface CoolerService extends NamedService< Cooler >, OnOffServiceImpl< Cooler, CoolerDTO >, DoubleSensorServiceImpl< Cooler, CoolerDTO >
{
}
