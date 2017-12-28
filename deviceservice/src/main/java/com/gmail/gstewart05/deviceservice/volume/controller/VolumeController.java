package com.gmail.gstewart05.deviceservice.volume.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.controller.NamedController;
import com.gmail.gstewart05.deviceservice.volume.model.Volume;
import com.gmail.gstewart05.deviceservice.volume.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/volume/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class VolumeController extends NamedController< Volume >
{
	@Autowired
	ObjectMapper theObjectMapper;

	@Autowired
	VolumeService theVolumeService;

	@Override
	public VolumeService getService()
	{
		return theVolumeService;
	}
}
