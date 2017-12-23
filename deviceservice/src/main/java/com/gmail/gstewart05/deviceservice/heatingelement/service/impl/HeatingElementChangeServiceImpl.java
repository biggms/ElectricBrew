package com.gmail.gstewart05.deviceservice.heatingelement.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractBooleanDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractBooleanDeviceService;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementChangeService;
import com.gmail.gstewart05.deviceservice.heatingelement.service.HeatingElementService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.HeatingElementDTO;
import com.gmail.gstewart05.deviceservice.heatingelement.model.devices.HeatingElement;
import com.gmail.gstewart05.deviceservice.heatingelement.model.change.HeatingElementChange;
import com.gmail.gstewart05.deviceservice.heatingelement.model.repo.HeatingElementChangeRepository;
import com.gmail.gstewart05.utils.LogUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HeatingElementChangeServiceImpl extends AbstractBooleanDeviceChangeServiceImpl< HeatingElement, HeatingElementDTO, HeatingElementChange > implements HeatingElementChangeService
{
	@Autowired
	HeatingElementChangeRepository theRepository;

	@Autowired
	HeatingElementService theHeatingElementService;

	@Override
	public HeatingElementChangeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public HeatingElementChange getNew()
	{
		return new HeatingElementChange();
	}

	@Override
	public HeatingElementService getDeviceService()
	{
		return theHeatingElementService;
	}

	@Override
	public String getSimpleName()
	{
		return HeatingElementChange.class.getSimpleName();
	}
}
