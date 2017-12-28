package com.gmail.gstewart05.deviceservice.temperature.model.repo;

import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends NamedEntityRepository< Temperature >
{
	Temperature findByMacIgnoreCase( String pMac );
}
