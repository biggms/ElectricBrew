package com.gmail.gstewart05.model;

import com.gmail.gstewart05.model.repo.BaseEntityRepository;
import com.gmail.gstewart05.utils.Level;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends BaseEntityRepository< Log >
{
	List< Log > findByLevel( Level pLevel );
}
