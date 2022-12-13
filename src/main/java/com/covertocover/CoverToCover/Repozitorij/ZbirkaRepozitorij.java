package com.covertocover.CoverToCover.Repozitorij;

import com.covertocover.CoverToCover.Modeli.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZbirkaRepozitorij extends CrudRepository<Zbirka, Long>{

    //Izpis zbirk, ki vsebujejo več kot x knjig
    @Query(value="SELECT z.ime FROM zbirka z LEFT JOIN zbirka_knjige zk ON zk.zbirka_id = z.id LEFT JOIN knjiga k ON zk.knjiga_id = k.id GROUP BY z.id HAVING COUNT(k.id)>= ? ;", nativeQuery=true)
    List<Zbirka> vrniZbirkeKnjig(int steviloKnjig);

    //Izpis imen zbirk od uporabnika x
    @Query(value="SELECT z.id, z.ime, u.ime, u.priimek FROM zbirka z INNER JOIN uporabnik u ON z.uporabnik_id = u.id", nativeQuery=true)
    List<Zbirka> vrniZbirkeUporabnika(int uporabnikId);
}