package com.gmail.gstewart05.deviceservice.pump.model.repo;

import com.gmail.gstewart05.deviceservice.pump.model.Pump;
import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PumpRepository extends NamedEntityRepository< Pump >
{
}
