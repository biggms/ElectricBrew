package com.gmail.gstewart05.hotwaterservice.model.repo;

import com.gmail.gstewart05.hotwaterservice.model.HotWater;
import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotWaterRepository extends NamedEntityRepository< HotWater >
{
}
