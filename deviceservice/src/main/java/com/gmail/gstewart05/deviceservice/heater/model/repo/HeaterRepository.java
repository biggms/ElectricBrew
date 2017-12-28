package com.gmail.gstewart05.deviceservice.heater.model.repo;

import com.gmail.gstewart05.deviceservice.heater.model.Heater;
import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaterRepository extends NamedEntityRepository< Heater >
{
}
