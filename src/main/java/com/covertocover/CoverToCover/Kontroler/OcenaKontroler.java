package com.covertocover.CoverToCover.Kontroler;

import com.covertocover.CoverToCover.Modeli.Ocena;
import com.covertocover.CoverToCover.Repozitorij.OcenaRepozitorij;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
