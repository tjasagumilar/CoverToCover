package com.covertocover.CoverToCover.Kontroler;

import com.covertocover.CoverToCover.Modeli.Knjiga;
import com.covertocover.CoverToCover.Modeli.Zanr;
import com.covertocover.CoverToCover.Repozitorij.KnjigaRepozitorij;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/knjiga")
public class KnjigaKontroler {

    @Autowired
    private KnjigaRepozitorij knjigaDao;

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

        if(!knjigaDao.existsById(id))
            return null;

        knjiga.setId(id);
        return knjigaDao.save(knjiga);
    }

    @DeleteMapping("{id}")
    public Boolean izbrisiKnjigo(@PathVariable(name="id") Long id) {

        if(!knjigaDao.existsById(id))
            return false;
        knjigaDao.deleteById(id);
        return true;
    }

    @GetMapping("/zanr/{zanr}/stStrani/{stStrani}")
    public Iterable<Knjiga> vrniIzbranoKnjigo(@PathVariable(name = "zanr") Zanr zanr, @PathVariable(name = "stStrani") int stStrani) {
        return knjigaDao.vrniIzbranoKnjigo(zanr, stStrani);
    }

    @GetMapping("/zanr/{zanr}/stStrani/{stStrani}/ocena/{ocena}")
    public Iterable<Knjiga> vrniKnjigoZanra(@PathVariable(name = "zanr") Zanr zanr, @PathVariable(name = "stStrani") int stStrani, @PathVariable(name = "ocena") int ocena) {
        return knjigaDao.vrniKnjigoZanra(zanr, stStrani, ocena);
    }

    @GetMapping("/zanr/{zanr}/stStrani/{stStrani}/avtorId/{avtorId}")
    public Iterable<Knjiga> vrniKnjigoAvtor(@PathVariable(name="zanr") Zanr zanr, @PathVariable(name="stStrani") int stStrani, @PathVariable(name = "avtorId") int avtorId) {
        return knjigaDao.vrniKnjigoAvtor(zanr, stStrani, avtorId);
    }
}
