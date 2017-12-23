package com.gmail.gstewart05.deviceservice.volume.service.impl;

import com.gmail.gstewart05.deviceservice.common.service.devices.impl.AbstractDoubleDeviceServiceImpl;
import com.gmail.gstewart05.deviceservice.volume.model.devices.Volume;
import com.gmail.gstewart05.deviceservice.volume.model.repo.VolumeRepository;
import com.gmail.gstewart05.deviceservice.volume.service.VolumeService;
import com.gmail.gstewart05.dto.DTOFactory;
import com.gmail.gstewart05.dto.DoubleDTO;
import com.gmail.gstewart05.dto.VolumeDTO;
import com.gmail.gstewart05.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolumeServiceImpl extends AbstractDoubleDeviceServiceImpl< Volume, VolumeDTO > implements VolumeService
{
	@Autowired
	VolumeRepository theRepository;
	@Autowired
	private LogUtil theLogUtil;
	@Autowired
	private DTOFactory theDTOFactory;

	@Override
	public VolumeRepository getRepository()
	{
		return theRepository;
	}

	@Override
	public DoubleDTO getDTO()
	{
		return theDTOFactory.getVolumeDTO();
	}

	@Override
	public String getSimpleName()
	{
		return Volume.class.getSimpleName();
	}
}
