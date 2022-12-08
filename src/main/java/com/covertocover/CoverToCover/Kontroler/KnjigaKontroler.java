package com.covertocover.CoverToCover.Kontroler;

import com.covertocover.CoverToCover.Modeli.Knjiga;
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
    public Knjiga dodajUporabnika(@RequestBody Knjiga knjiga)
    {return knjigaDao.save(knjiga);}
}
