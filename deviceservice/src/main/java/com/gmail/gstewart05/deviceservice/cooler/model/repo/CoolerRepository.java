package com.gmail.gstewart05.deviceservice.cooler.model.repo;

import com.gmail.gstewart05.deviceservice.cooler.model.Cooler;
import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoolerRepository extends NamedEntityRepository< Cooler >
{
}
