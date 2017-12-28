package com.gmail.gstewart05.deviceservice.bubbler.model.repo;

import com.gmail.gstewart05.deviceservice.bubbler.model.Bubbler;
import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import org.springframework.stereotype.Repository;

@Repository
public interface BubblerRepository extends NamedEntityRepository< Bubbler >
{
}
