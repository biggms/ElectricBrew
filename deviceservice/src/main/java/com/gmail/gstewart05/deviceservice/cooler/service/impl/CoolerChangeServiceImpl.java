package com.gmail.gstewart05.deviceservice.cooler.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractBooleanDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.cooler.model.change.CoolerChange;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import com.gmail.gstewart05.deviceservice.cooler.model.repo.CoolerChangeRepository;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerChangeService;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerService;
import com.gmail.gstewart05.dto.CoolerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CoolerChangeServiceImpl extends AbstractBooleanDeviceChangeServiceImpl< Cooler, CoolerDTO, CoolerChange > implements CoolerChangeService
{
	@Autowired
	CoolerChangeRepository theRepository;

	@Autowired
	CoolerService theCoolerService;

	@Override
	public CoolerChangeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public CoolerChange getNew()
	{
		return new CoolerChange();
	}

	@Override
	public CoolerService getDeviceService()
	{
		return theCoolerService;
	}

	@Override
	public String getSimpleName()
	{
		return CoolerChange.class.getSimpleName();
	}
}
