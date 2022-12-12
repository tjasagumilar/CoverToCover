package com.covertocover.CoverToCover.Repozitorij;

import com.covertocover.CoverToCover.Modeli.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KnjigaRepozitorij extends CrudRepository<Knjiga, Long> {

    @Query(value="SELECT * FROM knjiga k WHERE k.stevilo_strani<=500 AND k.leto_izdaje>=2000", nativeQuery=true)
    List<Knjiga> vrniKnjigoZanra(int stStrani, int letoIzdaje);

    @Query(value="SELECT * FROM knjiga k WHERE k.zanr_id = 1  AND k.stevilo_strani>=200 AND k.leto_izdaje>=2000", nativeQuery=true)
    List<Knjiga> vrniKnjigoLeta(int zanr, int stStrani, int letoIzdaje);

    @Query(value="SELECT * FROM knjiga k WHERE k.zanr_id = 2 AND k.stevilo_strani>=300 AND k.avtor_id = 2", nativeQuery=true)
    List<Knjiga> vrniKnjigoAvtorja(Zanr zanr, int stStrani, int avtorId);


}
