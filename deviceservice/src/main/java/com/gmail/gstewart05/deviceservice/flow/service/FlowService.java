package com.gmail.gstewart05.deviceservice.flow.service;

import com.gmail.gstewart05.deviceservice.flow.model.Flow;
import com.gmail.gstewart05.dto.FlowDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;

public interface FlowService extends NamedService< Flow >, OnOffServiceImpl< Flow, FlowDTO >
{
}
