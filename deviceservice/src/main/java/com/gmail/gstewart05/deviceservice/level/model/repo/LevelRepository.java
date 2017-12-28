package com.gmail.gstewart05.deviceservice.level.model.repo;

import com.gmail.gstewart05.deviceservice.level.model.Level;
import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends NamedEntityRepository< Level >
{
}
