package com.covertocover.CoverToCover.Repozitorij;

import com.covertocover.CoverToCover.Modeli.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZbirkaRepozitorij extends CrudRepository<Zbirka, Long>{

}
