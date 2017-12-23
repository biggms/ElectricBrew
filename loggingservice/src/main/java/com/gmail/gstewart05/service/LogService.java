package com.gmail.gstewart05.service;

import com.gmail.gstewart05.model.Log;
import com.gmail.gstewart05.utils.Level;

import java.util.List;

public interface LogService
{
	List< Log > getAll();

	Log save( Log pLog );

	List< Log > getByLevel( Level pLevel );
}
