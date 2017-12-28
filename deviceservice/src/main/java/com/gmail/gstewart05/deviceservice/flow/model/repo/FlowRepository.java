package com.gmail.gstewart05.deviceservice.flow.model.repo;

import com.gmail.gstewart05.deviceservice.flow.model.Flow;
import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRepository extends NamedEntityRepository< Flow >
{
}
