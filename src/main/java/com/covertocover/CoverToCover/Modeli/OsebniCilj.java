package com.covertocover.CoverToCover.Modeli;

import jakarta.persistence.*;

@Entity
public class OsebniCilj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Knjiga knjiga;
    private double cas;
    private int steviloKnjig;
    public Uporabnik uporabnik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
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
}