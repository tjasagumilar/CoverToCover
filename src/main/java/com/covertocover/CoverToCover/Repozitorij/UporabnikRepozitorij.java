package com.covertocover.CoverToCover.Repozitorij;


import com.covertocover.CoverToCover.Modeli.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UporabnikRepozitorij extends CrudRepository<Uporabnik, Long>{

    @Query(value="SELECT * FROM uporabnik u WHERE u.ime='janez' AND u.priimek='horvat' ", nativeQuery=true)
    List<Uporabnik> vrniDolocenegaUporabnika(String ime, String priimek);

    @Query(value="SELECT * FROM uporabnik u WHERE u.ime='janez' AND u.uporabniskoIme LIKE %janezhorvat% AND u.priimek='horvat' ", nativeQuery=true)
    List<Uporabnik> vrniUporabniskiNiz(String ime, String uporabniskoIme, String priimek);

    @Query(value="SELECT * FROM uporabnik u WHERE u.geslo LIKE %horvat% OR u.uporabniskoIme LIKE %horvat% OR u.priimek = %horvat%", nativeQuery=true)
    List<Uporabnik> vrniUporabnikeNovake(String geslo, String uporabniskoIme, String priimek);

}
