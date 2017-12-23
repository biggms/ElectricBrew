package com.gmail.gstewart05.service;

import com.gmail.gstewart05.model.Log;
import com.gmail.gstewart05.model.LogRepository;
import com.gmail.gstewart05.utils.Level;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService
{
	@Autowired
	LogRepository theLogRepository;

	@Override
	public List< Log > getAll()
	{
		return Lists.newArrayList( theLogRepository.findAll() );
	}

	@Override
	public Log save( Log pLog )
	{
		return theLogRepository.save( pLog );
	}

	@Override
	public List< Log > getByLevel( Level pLevel )
	{
		return Lists.newArrayList( theLogRepository.findByLevel( pLevel ) );
	}
}
