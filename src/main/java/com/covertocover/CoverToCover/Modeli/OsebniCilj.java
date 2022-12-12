package com.covertocover.CoverToCover.Modeli;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Vector;

@Entity
public class OsebniCilj {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    public Vector<Knjiga> knjige = new Vector<Knjiga>();
    private double cas;
    private int steviloKnjig;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "uporabnik.id") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
    private Uporabnik uporabnik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vector<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(Vector<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public double getCas() {
        return cas;
    }

    public void setCas(double cas) {
        this.cas = cas;
    }

    public int getSteviloKnjig() {
        return steviloKnjig;
    }

    public void setSteviloKnjig(int steviloKnjig) {
        this.steviloKnjig = steviloKnjig;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }
}