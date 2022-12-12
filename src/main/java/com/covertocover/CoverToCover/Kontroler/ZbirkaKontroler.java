package com.covertocover.CoverToCover.Kontroler;

import com.covertocover.CoverToCover.Modeli.*;
import com.covertocover.CoverToCover.Repozitorij.ZbirkaRepozitorij;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
