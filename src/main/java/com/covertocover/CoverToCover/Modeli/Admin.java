package com.covertocover.CoverToCover.Modeli;

import jakarta.persistence.*;

@Entity
public class Admin extends Uporabnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naziv;

    public void vnosKnjig(Knjiga aKnjiga) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}

