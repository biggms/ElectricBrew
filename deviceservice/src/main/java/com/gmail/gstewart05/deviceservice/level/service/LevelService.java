package com.gmail.gstewart05.deviceservice.level.service;

import com.gmail.gstewart05.deviceservice.level.model.Level;
import com.gmail.gstewart05.dto.LevelDTO;
import com.gmail.gstewart05.service.NamedService;
import com.gmail.gstewart05.service.wrappers.OnOffServiceImpl;

public interface LevelService extends NamedService< Level >, OnOffServiceImpl< Level, LevelDTO >
{
}
