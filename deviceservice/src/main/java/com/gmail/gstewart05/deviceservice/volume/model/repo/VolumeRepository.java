package com.gmail.gstewart05.deviceservice.volume.model.repo;

import com.gmail.gstewart05.model.repo.NamedEntityRepository;
import com.gmail.gstewart05.deviceservice.volume.model.Volume;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeRepository extends NamedEntityRepository< Volume >
{
}
