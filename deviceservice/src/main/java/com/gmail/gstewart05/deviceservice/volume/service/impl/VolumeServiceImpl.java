package com.gmail.gstewart05.deviceservice.volume.service.impl;

import com.gmail.gstewart05.deviceservice.volume.model.Volume;
import com.gmail.gstewart05.deviceservice.volume.model.repo.VolumeRepository;
import com.gmail.gstewart05.deviceservice.volume.service.VolumeService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.VolumeDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.impl.NamedServiceImpl;
import com.gmail.gstewart05.service.wrappers.DoubleSensorServiceImpl;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolumeServiceImpl extends NamedServiceImpl< Volume > implements VolumeService
{
	@Autowired
	VolumeRepository theRepository;

	@Autowired
	private DTOFactory theDTOFactory;

	@Autowired
	LogUtil theLogUtil;

	@Override
	public VolumeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public String getSimpleName()
	{
		return Volume.class.getSimpleName();
	}

	@Override
	public NamedService< Volume > getService()
	{
		return this;
	}

	@Override
	public LogUtil getLogUtil()
	{
		return theLogUtil;
	}

	@Override
	public VolumeDTO getDTO()
	{
		return theDTOFactory.getVolumeDTO();
	}
}