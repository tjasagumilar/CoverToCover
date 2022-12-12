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

    @DeleteMapping("{id}")
    public Boolean odstraniZbirko(@PathVariable(name="id") Long id) {

        if(!zbirkaDao.existsById(id)) {
            return false;
        } else {
            zbirkaDao.deleteById(id);
            return true;
        }
    }

    @GetMapping("zbirke/{stevilo_knjig}")
    public Iterable<Zbirka> vrniZbirkeKnjig(@PathVariable(name="stevilo_knjig") int stevilo_knjig) {
        return zbirkaDao.vrniZbirkeKnjig(stevilo_knjig);
    }

    @GetMapping("zbirkaUporabnika/{uporabnik_id}")
    public Iterable<Zbirka> vrniZbirkeUporabnika(@PathVariable(name="uporabnik_id") int uporabnik_id) {
        return zbirkaDao.vrniZbirkeKnjig(uporabnik_id);
    }

}
