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

    @GetMapping("/zanr/{zanr}/stStrani/{stStrani}")
    public Iterable<Knjiga> vrniKnjigoZanra(@PathVariable(name = "zanr") Zanr zanr, @PathVariable(name = "stStrani") int stStrani) {
        return knjigaDao.vrniKnjigoZanra(zanr, stStrani);
    }

    @GetMapping("/zanr/{zanr}/stStrani/{stStrani}/leto/{leto}")
    public Iterable<Knjiga> vrniKnjigoLeta(@PathVariable(name = "zanr") Zanr zanr, @PathVariable(name = "stStrani") int stStrani, @PathVariable(name = "leto") int leto) {
        return knjigaDao.vrniKnjigoLeta(zanr, stStrani, leto);
    }

    @GetMapping("/zanr/{zanr}/stStrani/{stStrani}/avtorId/{avtorId}")
    public Iterable<Knjiga> vrniKnjigoAvtorja(@PathVariable(name="zanr") Zanr zanr, @PathVariable(name="stStrani") int stStrani, @PathVariable(name = "avtorId") int avtorId) {
        return knjigaDao.vrniKnjigoAvtorja(zanr, stStrani, avtorId);
    }
}
