package com.covertocover.CoverToCover.Repozitorij;

import com.covertocover.CoverToCover.Modeli.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KnjigaRepozitorij extends CrudRepository<Knjiga, Long> {

    //Izpis knjig, ki imajo manj strani kot x in so izdane po letu y
    @Query(value="SELECT * FROM knjiga k WHERE k.stevilo_strani<= ? AND k.leto_izdaje>= ?", nativeQuery=true)
    List<Knjiga> vrniKnjigoZanra(int stStrani, int letoIzdaje);

    //Izpis knjig, ki so zanra x, imajo več kot y strani in so izdane po letu z
    @Query(value="SELECT * FROM knjiga k WHERE k.zanr_id = ?  AND k.stevilo_strani>= ? AND k.leto_izdaje>= ?", nativeQuery=true)
    List<Knjiga> vrniKnjigoLeta(int zanr, int stStrani, int letoIzdaje);

    //Izpis knjig, ki so zanra x, imajo vec kot y strani in avtor je z
    @Query(value="SELECT * FROM knjiga k WHERE k.zanr_id = ? AND k.stevilo_strani>= ? AND k.avtor_id = ?", nativeQuery=true)
    List<Knjiga> vrniKnjigoAvtorja(int zanr, int stStrani, int avtorId);


}
