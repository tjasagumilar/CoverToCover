package com.covertocover.CoverToCover.Kontroler;

import com.covertocover.CoverToCover.Modeli.*;
import com.covertocover.CoverToCover.Repozitorij.KnjigaRepozitorij;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/knjiga")
public class KnjigaKontroler {

    @Autowired
    private KnjigaRepozitorij knjigaDao;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("")
    public Iterable<Knjiga> vrniVseKnjige() {
        return knjigaDao.findAll();
    }

    @GetMapping("{id}")
    public Optional<Knjiga> vrniKnjigo(@PathVariable(name="id") Long id) {
        return knjigaDao.findById(id);
    }

    @PostMapping("")
    public Knjiga dodajKnjigo(@RequestBody Knjiga knjiga) {
        return knjigaDao.save(knjiga);
    }

    @PutMapping("{id}")
    public Knjiga spremeniKnjigo(@PathVariable(name="id") Long id, @RequestBody Knjiga knjiga) {

        if(!knjigaDao.existsById(id)) {
            return null;
        } else {
            knjiga.setId(id);
            return knjigaDao.save(knjiga);
        }
    }

    @DeleteMapping("{id}")
    public Boolean odstraniKnjigo(@PathVariable(name="id") Long id) {

        if(!knjigaDao.existsById(id)) {
            return false;
        } else {
            knjigaDao.deleteById(id);
            return true;
        }
    }

    @GetMapping("stStrani/{stevilo_strani}/letoIzdaje/{leto_izdaje}")
    public Iterable<Knjiga> vrniKnjigoZanra(@PathVariable(name = "stevilo_strani") int stevilo_strani, @PathVariable(name = "leto_izdaje") int leto_izdaje) {
        return knjigaDao.vrniKnjigoZanra(stevilo_strani, leto_izdaje);
    }

    @GetMapping("/zanr/{zanr_id}/stStrani/{stevilo_strani}/letoIzdaje/{leto_izdaje}")
    public Iterable<Knjiga> vrniKnjigoLeta(@PathVariable(name = "zanr_id") int zanr_id, @PathVariable(name = "stevilo_strani") int stevilo_strani, @PathVariable(name = "leto_izdaje") int leto_izdaje) {
        return knjigaDao.vrniKnjigoLeta(zanr_id, stevilo_strani, leto_izdaje);
    }

    @GetMapping("/zanr/{zanr_id}/stStrani/{sttevilo_strani}/avtor/{avtor_id}")
    public Iterable<Knjiga> vrniKnjigoAvtorja(@PathVariable(name="zanr_id") Zanr zanr_id, @PathVariable(name="stevilo_strani") int stevilo_strani, @PathVariable(name = "avtor_id") int avtor_id) {
        return knjigaDao.vrniKnjigoAvtorja(zanr_id, stevilo_strani, avtor_id);
    }
}
