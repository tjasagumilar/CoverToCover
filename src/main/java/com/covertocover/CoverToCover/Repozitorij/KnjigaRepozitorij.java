package com.covertocover.CoverToCover.Repozitorij;

import com.covertocover.CoverToCover.Modeli.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KnjigaRepozitorij extends CrudRepository<Knjiga, Long> {

    @Query(value="SELECT * FROM knjiga v WHERE k.zanr = 'romanca' AND k.stStrani<=?500", nativeQuery=true)
    List<Knjiga> vrniKnjigoZanra(Zanr zanr, int stStrani);

    @Query(value="SELECT * FROM knjiga v WHERE k.zanr = 'pravljica'  AND k.stStrani<=?200 AND k.leto>=2000", nativeQuery=true)
    List<Knjiga> vrniKnjigoLeta(Zanr zanr, int stStrani, int leto);

    @Query(value="SELECT * FROM knjiga v WHERE k.zanr = 'literatura' AND  k.stStrani>=?300 AND k.avtorId = 2", nativeQuery=true)
    List<Knjiga> vrniKnjigoAvtorja(Zanr zanr, int stStrani, int avtorId);


}
