package com.gmail.gstewart05.deviceservice.flow.service.impl;

import com.gmail.gstewart05.deviceservice.flow.model.Flow;
import com.gmail.gstewart05.deviceservice.flow.model.repo.FlowRepository;
import com.gmail.gstewart05.deviceservice.flow.service.FlowService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.FlowDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.impl.NamedServiceImpl;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowServiceImpl extends NamedServiceImpl< Flow > implements FlowService
{
	@Autowired
	FlowRepository theRepository;

	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	LogUtil theLogUtil;

	@Override
	public FlowRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public String getSimpleName()
	{
		return Flow.class.getSimpleName();
	}

	@Override
	public NamedService< Flow > getService()
	{
		return this;
	}

	@Override
	public LogUtil getLogUtil()
	{
		return theLogUtil;
	}

	@Override
	public FlowDTO getDTO()
	{
		return theDTOFactory.getFlowDTO();
	}
}