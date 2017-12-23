package com.gmail.gstewart05.deviceservice.cooler.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractBooleanDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractBooleanDeviceService;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerChangeService;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.CoolerDTO;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import com.gmail.gstewart05.deviceservice.cooler.model.change.CoolerChange;
import com.gmail.gstewart05.deviceservice.cooler.model.repo.CoolerChangeRepository;
import com.gmail.gstewart05.utils.LogUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
