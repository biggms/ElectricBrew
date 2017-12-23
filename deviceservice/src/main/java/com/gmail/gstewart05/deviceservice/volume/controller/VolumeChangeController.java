package com.gmail.gstewart05.deviceservice.volume.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.volume.model.change.VolumeChange;
import com.gmail.gstewart05.deviceservice.volume.model.devices.Volume;
import com.gmail.gstewart05.deviceservice.volume.service.VolumeChangeService;
import com.gmail.gstewart05.deviceservice.volume.service.VolumeService;
import com.gmail.gstewart05.dto.VolumeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/volumechange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class VolumeChangeController extends AbstractDeviceChangeController< Volume, VolumeDTO, VolumeChange >
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	VolumeChangeService theVolumeChangeService;

	@Autowired
	VolumeService theVolumeService;

	@Override
	public VolumeChangeService getChangeService()
	{
		return theVolumeChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return VolumeChange.class.getSimpleName();
	}

	@Override
	public VolumeService getDeviceService()
	{
		return theVolumeService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return Volume.class.getSimpleName();
	}
}
