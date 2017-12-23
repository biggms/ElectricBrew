package com.gmail.gstewart05.deviceservice.volume.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.volume.model.devices.Volume;
import com.gmail.gstewart05.deviceservice.volume.service.VolumeService;
import com.gmail.gstewart05.dto.VolumeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/volume/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class VolumeController extends AbstractDeviceController< Volume, VolumeDTO >
{
	ObjectMapper theObjectMapper = new ObjectMapper();

	@Autowired
	VolumeService theVolumeService;

	@Override
	public VolumeService getService()
	{
		return theVolumeService;
	}

	@Override
	public String getSimpleName()
	{
		return Volume.class.getSimpleName();
	}
}
