package com.gmail.gstewart05.deviceservice.bubbler.service;

import com.gmail.gstewart05.deviceservice.bubbler.model.Bubbler;
import com.gmail.gstewart05.dto.BubblerDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;

public interface BubblerService extends NamedService< Bubbler >, OnOffServiceImpl< Bubbler, BubblerDTO >
{
}
