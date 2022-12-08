package com.covertocover.CoverToCover.Modeli;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Vector;

@Entity
public class Avtor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ime;
    private String priimek;
    public Vector<Knjiga> knjige = new Vector<Knjiga>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public Vector<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(Vector<Knjiga> knjige) {
        this.knjige = knjige;
    }
}
