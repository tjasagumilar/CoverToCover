package com.covertocover.CoverToCover.Kontroler;

import com.covertocover.CoverToCover.*;
import com.covertocover.CoverToCover.Modeli.Uporabnik;
import com.covertocover.CoverToCover.Repozitorij.UporabnikRepozitorij;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/uporabnik")
public class UporabnikKontroler {
    @Autowired
    private UporabnikRepozitorij uporabnikRep;

    @GetMapping("")
    public Iterable<Uporabnik> vrniVseUporabnike() {
        return uporabnikRep.findAll();
    }

    @GetMapping("{id}")
    public Optional<Uporabnik> vrniEnegaUporabnika(@PathVariable(name="id") Long id) {
        return uporabnikRep.findById(id);
    }

    @PostMapping("")
    public Uporabnik dodajaUporabnika(@RequestBody Uporabnik uporabnik)
    {return uporabnikRep.save(uporabnik);}

    @PutMapping("{id}")
    public Uporabnik spremeniUporabnika(@PathVariable(name="id") Long id, @RequestBody Uporabnik uporabnik) {

        if(!uporabnikRep.existsById(id))
            return null;

        uporabnik.setId(id);
        return uporabnikRep.save(uporabnik);
    }

    @DeleteMapping("{id}")
    public Boolean brisiUporabnika(@PathVariable(name="id") Long id) {

        if(!uporabnikRep.existsById(id))
            return false;
        uporabnikRep.deleteById(id);
        return true;
    }

    @GetMapping("/ime/{ime}/priimek/{priimek}")
    public Iterable<Uporabnik> vrniSpecificnegaUporabnika(@PathVariable(name = "ime") String ime, @PathVariable(name = "priimek") String priimek) {
        return uporabnikRep.vrniSpecificnegaUporabnika(ime, priimek);
    }

    @GetMapping("/ime/{ime}/email/{email}/priimek/{priimek}")
    public Iterable<Uporabnik> vrniUporabniskiNiz(@PathVariable(name = "ime") String ime, @PathVariable(name = "email") String email, @PathVariable(name = "priimek") String priimek) {
        return uporabnikRep.vrniUporabniskiNiz(ime, email, priimek);
    }

    @GetMapping("/geslo/{geslo}/email/{email}/priimek/{priimek}")
    public Iterable<Uporabnik> vrniUporabnikeHorvate(@PathVariable(name="geslo") String geslo, @PathVariable(name="email") String email, @PathVariable(name = "priimek") String priimek) {
        return uporabnikRep.vrniUporabnikeHorvate(geslo, email, priimek);
    }

    //s

}
