package com.covertocover.CoverToCover.Repozitorij;


import com.covertocover.CoverToCover.Modeli.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UporabnikRepozitorij extends CrudRepository<Uporabnik, Long>{

    @Query(value="SELECT * FROM uporabnik u WHERE u.ime= ? AND u.priimek= ? ", nativeQuery=true)
    List<Uporabnik> vrniSpecificnegaUporabnika(String ime, String priimek);

    @Query(value="SELECT * FROM uporabnik u WHERE u.ime= ? AND u.email LIKE ? AND u.priimek= ? ", nativeQuery=true)
    List<Uporabnik> vrniUporabniskiNiz(String ime, String email, String priimek);

    @Query(value="SELECT * FROM uporabnik u WHERE u.geslo LIKE ? OR u.email LIKE ? OR u.priimek = ?", nativeQuery=true)
    List<Uporabnik> vrniUporabnikeHorvate(String geslo, String email, String priimek);

    //registracija
    @Query(value="SELECT * FROM uporabnik u WHERE u.email = ? ", nativeQuery=true)
    List<Uporabnik> preveriObstojEmail(String email);

    //prijava
    @Query(value="SELECT * FROM uporabnik u WHERE u.geslo = ? AND u.email = ? LIMIT 1 ", nativeQuery=true)
    List<Uporabnik> vrniUporabnikLogin(String geslo, String email);

}

