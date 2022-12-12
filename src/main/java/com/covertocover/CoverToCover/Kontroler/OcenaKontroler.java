package com.covertocover.CoverToCover.Kontroler;

import com.covertocover.CoverToCover.Modeli.Ocena;
import com.covertocover.CoverToCover.Modeli.Zbirka;
import com.covertocover.CoverToCover.Repozitorij.OcenaRepozitorij;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ocena")
public class OcenaKontroler {

    @Autowired
    private OcenaRepozitorij ocenaRep;

    @GetMapping("")
    public Iterable<Ocena> vrniVseZbirke() {
        return ocenaRep.findAll();
    }

    @GetMapping("{id}")
    public Optional<Ocena> vrniZbirko(@PathVariable(name="id") Long id) {
        return ocenaRep.findById(id);
    }

    @PostMapping("")
    public Ocena dodajOceno(@RequestBody Ocena ocena) {
        return ocenaRep.save(ocena);
    }
}
