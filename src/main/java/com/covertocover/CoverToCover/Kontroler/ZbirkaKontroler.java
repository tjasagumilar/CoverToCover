package com.covertocover.CoverToCover.Kontroler;

import com.covertocover.CoverToCover.Modeli.*;
import com.covertocover.CoverToCover.Repozitorij.ZbirkaRepozitorij;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/zbirka")
public class ZbirkaKontroler {

    @Autowired
    private ZbirkaRepozitorij zbirkaDao;

    @GetMapping("")
    public Iterable<Zbirka> vrniVseZbirke() {
        return zbirkaDao.findAll();
    }

    @GetMapping("{id}")
    public Optional<Zbirka> vrniZbirko(@PathVariable(name="id") Long id) {
        return zbirkaDao.findById(id);
    }

    @PostMapping("")
    public Zbirka dodajZbirko(@RequestBody Zbirka zbirka) {
        return zbirkaDao.save(zbirka);
    }

    @PutMapping("{id}")
    public Zbirka spremeniZbirko(@PathVariable(name="id") Long id, @RequestBody Zbirka zbirka) {

        if(!zbirkaDao.existsById(id)) {
            return null;
        } else {
            zbirka.setId(id);
            return zbirkaDao.save(zbirka);
        }
    }
}
