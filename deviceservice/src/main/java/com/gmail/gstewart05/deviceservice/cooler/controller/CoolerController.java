package com.gmail.gstewart05.deviceservice.cooler.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceController;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerService;
import com.gmail.gstewart05.dto.BooleanDTO;
import com.gmail.gstewart05.dto.CoolerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/cooler/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class CoolerController extends AbstractDeviceController< Cooler, CoolerDTO >
{
	@Autowired
	CoolerService theCoolerService;

	@Override
	public CoolerService getService()
	{
		return theCoolerService;
	}

	@Override
	public String getSimpleName()
	{
		return Cooler.class.getSimpleName();
	}
}
