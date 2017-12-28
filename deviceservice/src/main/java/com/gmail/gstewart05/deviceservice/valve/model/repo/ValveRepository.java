package com.gmail.gstewart05.deviceservice.valve.model.repo;

import com.gmail.gstewart05.deviceservice.valve.model.Valve;
import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import org.springframework.stereotype.Repository;

@Repository
public interface ValveRepository extends NamedEntityRepository< Valve >
{
}
