package com.covertocover.CoverToCover.Modeli;

import jakarta.persistence.*;
import java.util.Vector;

@Entity
public class Knjiga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naslov;
    private Avtor avtor;
    private Zanr zanr;
    private int steviloStrani;
    private Ocena ocena;
    public Zanr zanrKnjige;
    @ManyToMany
    public Vector<Avtor> avtorji = new Vector<Avtor>();

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Avtor getAvtor() {
        return avtor;
    }

    public void setAvtor(Avtor avtor) {
        this.avtor = avtor;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public int getSteviloStrani() {
        return steviloStrani;
    }

    public void setSteviloStrani(int steviloStrani) {
        this.steviloStrani = steviloStrani;
    }

    public Ocena getOcena() {
        return ocena;
    }

    public void setOcena(Ocena ocena) {
        this.ocena = ocena;
    }

    public Zanr getZanrKnjige() {
        return zanrKnjige;
    }

    public void setZanrKnjige(Zanr zanrKnjige) {
        this.zanrKnjige = zanrKnjige;
    }

    public Vector<Avtor> getAvtorji() {
        return avtorji;
    }

    public void setAvtorji(Vector<Avtor> avtorji) {
        this.avtorji = avtorji;
    }

}

