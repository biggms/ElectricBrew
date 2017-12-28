package com.gmail.gstewart05.model.repo;

import com.gmail.gstewart05.model.BaseEntity;
import com.gmail.gstewart05.model.NamedEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseEntityRepository< T extends BaseEntity > extends PagingAndSortingRepository< T, String >, RevisionRepository< T, String, Integer >
{

}
