package com.covertocover.CoverToCover.Repozitorij;

import com.covertocover.CoverToCover.Modeli.Knjiga;
import com.covertocover.CoverToCover.Modeli.Zanr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KnjigaRepozitorij extends CrudRepository<Knjiga, Long> {

    @Query(value="SELECT * FROM knjiga v WHERE k.zanr = 'romanca' AND k.stStrani<=?500", nativeQuery=true)
    List<Knjiga> vrniIzbranoKnjigo(Zanr zanr, int stStrani);

    @Query(value="SELECT * FROM knjiga v WHERE k.zanr = 'pravljica'  AND k.stStrani<=?200 AND k.ocena>=?3 ", nativeQuery=true)
    List<Knjiga> vrniKnjigoZanra(Zanr zanr, int stStrani, int ocena);

    @Query(value="SELECT * FROM knjiga v WHERE k.zanr = 'literatura' AND  k.strani>=?300 AND k.avtorId = 2", nativeQuery=true)
    List<Knjiga> vrniKnjigoAvtor(Zanr zanr, int stStrani, int avtorId);

}
