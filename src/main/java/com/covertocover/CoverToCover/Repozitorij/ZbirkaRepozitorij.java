package com.covertocover.CoverToCover.Repozitorij;

import com.covertocover.CoverToCover.Modeli.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZbirkaRepozitorij extends CrudRepository<Zbirka, Long>{

    @Query(value="SELECT z.ime FROM zbirka z INNER JOIN zbirka_knjige k ON k.zbirka_id = z.id GROUP BY z.id HAVING COUNT(k.knjige_id)>=3 ;", nativeQuery=true)
    Iterable<Zbirka> vrniZbirkeKnjig(int steviloKnjig);

    @Query(value="SELECT z.ime FROM zbirka z INNER JOIN uporabnik u ON z.uporabnik_id = u.id WHERE u.id= 2", nativeQuery=true)
    Iterable<Zbirka> vrniZbirkeUporabnika(int uporabnikId);
}
