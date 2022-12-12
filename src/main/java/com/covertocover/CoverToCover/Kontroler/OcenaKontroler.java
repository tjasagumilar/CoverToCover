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

    @PutMapping("{id}")
    public Ocena spremeniOceno(@PathVariable(name="id") Long id, @RequestBody Ocena ocena) {

        if(!ocenaRep.existsById(id)) {
            return null;
        } else {
            ocena.setId(id);
            return ocenaRep.save(ocena);
        }
    }

    @DeleteMapping("{id}")
    public Boolean odstraniOceno(@PathVariable(name="id") Long id) {

        if(!ocenaRep.existsById(id)) {
            return false;
        } else {
            ocenaRep.deleteById(id);
            return true;
        }
    }

    @GetMapping("ocena/{stevilo_ocen}")
    public Iterable<Ocena> vrniOceneKnjige(@PathVariable(name="stevilo_ocen") int stevilo_ocen) {
        return ocenaRep.vrniOceneKnjige(stevilo_ocen);
    }

    @GetMapping("ocene/{uporabnik_id}")
    public Iterable<Ocena> vrniOceneUporbnika(@PathVariable(name="uporabnik_id") int uporabnik_id) {
        return ocenaRep.vrniOceneUporbnika(uporabnik_id);
    }

}
