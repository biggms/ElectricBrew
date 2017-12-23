package com.gmail.gstewart05.deviceservice.volume.service.impl;

import com.gmail.gstewart05.deviceservice.common.model.repo.AbstractDeviceChangeRepository;
import com.gmail.gstewart05.deviceservice.common.service.change.impl.AbstractDoubleDeviceChangeServiceImpl;
import com.gmail.gstewart05.deviceservice.volume.model.change.VolumeChange;
import com.gmail.gstewart05.deviceservice.volume.model.devices.Volume;
import com.gmail.gstewart05.deviceservice.volume.model.repo.VolumeChangeRepository;
import com.gmail.gstewart05.deviceservice.volume.service.VolumeChangeService;
import com.gmail.gstewart05.deviceservice.volume.service.VolumeService;
import com.gmail.gstewart05.dto.VolumeDTO;
import com.gmail.gstewart05.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VolumeChangeServiceImpl extends AbstractDoubleDeviceChangeServiceImpl< Volume, VolumeDTO, VolumeChange > implements VolumeChangeService
{
	@Autowired
	VolumeChangeRepository theRepository;

	@Autowired
	VolumeService theVolumeService;

	@Autowired
	private LogUtil theLogUtil;

	@Override
	public VolumeChange getNew()
	{
		return new VolumeChange();
	}

	@Override
	public VolumeService getDeviceService()
	{
		return theVolumeService;
	}

	@Override
	public String getSimpleName()
	{
		return VolumeChange.class.getSimpleName();
	}

	@Override
	public AbstractDeviceChangeRepository< Volume, VolumeChange > getRepository()
	{
		return theRepository;
	}
}
