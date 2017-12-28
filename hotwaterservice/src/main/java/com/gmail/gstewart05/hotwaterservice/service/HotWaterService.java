package com.gmail.gstewart05.hotwaterservice.service;

import com.gmail.gstewart05.dto.HotWaterDTO;
import com.gmail.gstewart05.hotwaterservice.model.HotWater;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.wrappers.DoubleSensorServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffMutatorServiceImpl;

public interface HotWaterService extends NamedService< HotWater >, OnOffMutatorServiceImpl< HotWater, HotWaterDTO >, DoubleSensorServiceImpl< HotWater, HotWaterDTO >
{
}
