package com.gmail.gstewart05.model;

import com.gmail.gstewart05.utils.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends CrudRepository< Log, String >
{
	List< Log > findByLevel( Level pLevel );
}
