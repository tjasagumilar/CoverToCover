package com.covertocover.CoverToCover.Repozitorij;

import com.covertocover.CoverToCover.Modeli.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcenaRepozitorij extends CrudRepository<Ocena, Long>{

    @Query(value="SELECT o.ocena FROM ocena o INNER JOIN knjiga k ON o.knjiga_id = k.id GROUP BY k.id WHERE k.id= 4", nativeQuery=true)
    Iterable<Ocena> vrniOceneKnjige(int steviloKnjig);

    @Query(value="SELECT o.ocena FROM ocena o INNER JOIN uporabnik u ON o.uporabnik_id = u.id GROUP BY u.id WHERE u.id= 6", nativeQuery=true)
    Iterable<Ocena> vrniOceneUporbnika(int uporabnikId);

}