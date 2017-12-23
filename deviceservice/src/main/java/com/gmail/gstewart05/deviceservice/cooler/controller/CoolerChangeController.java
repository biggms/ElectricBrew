package com.gmail.gstewart05.deviceservice.cooler.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmail.gstewart05.deviceservice.common.controller.AbstractDeviceChangeController;
import com.gmail.gstewart05.deviceservice.common.service.change.AbstractDeviceChangeService;
import com.gmail.gstewart05.deviceservice.common.service.devices.AbstractDeviceService;
import com.gmail.gstewart05.deviceservice.cooler.model.devices.Cooler;
import com.gmail.gstewart05.deviceservice.cooler.model.change.CoolerChange;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerChangeService;
import com.gmail.gstewart05.deviceservice.cooler.service.CoolerService;
import com.gmail.gstewart05.dto.CoolerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/coolerchange/v1" )
@RestController
@SuppressWarnings( "unchecked" )
public class CoolerChangeController extends AbstractDeviceChangeController< Cooler, CoolerDTO, CoolerChange >
{
	@Autowired
	CoolerChangeService theCoolerChangeService;

	@Autowired
	CoolerService theCoolerService;

	@Override
	public CoolerChangeService getChangeService()
	{
		return theCoolerChangeService;
	}

	@Override
	public String getSimpleName()
	{
		return CoolerChange.class.getSimpleName();
	}

	@Override
	public CoolerService getDeviceService()
	{
		return theCoolerService;
	}

	@Override
	public String getDeviceSimpleName()
	{
		return Cooler.class.getSimpleName();
	}
}