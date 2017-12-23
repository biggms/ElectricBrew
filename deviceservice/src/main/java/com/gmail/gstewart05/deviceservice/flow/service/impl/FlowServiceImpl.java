package com.gmail.gstewart05.deviceservice.flow.service.impl;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceRepository;
import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractBooleanDeviceServiceImpl;
import com.gmail.gstewart05.deviceservice.flow.model.devices.Flow;
import com.gmail.gstewart05.deviceservice.flow.model.repo.FlowRepository;
import com.gmail.gstewart05.deviceservice.flow.service.FlowService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.FlowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowServiceImpl extends AbstractBooleanDeviceServiceImpl< Flow, FlowDTO > implements FlowService
{
	@Autowired
	FlowRepository theRepository;
	@Autowired
	private DTOFactory theDTOFactory;

	@Override
	public BooleanDTO getDTO()
	{
		return theDTOFactory.getFlowDTO();
	}

	@Override
	public String getSimpleName()
	{
		return Flow.class.getSimpleName();
	}

	@Override
	public AbstractDeviceRepository< Flow > getRepository()
	{
		return theRepository;
	}
}
