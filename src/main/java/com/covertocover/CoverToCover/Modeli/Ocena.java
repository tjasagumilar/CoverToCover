package com.covertocover.CoverToCover.Modeli;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Ocena {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int ocena;
    private String komentar;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "knjiga.id") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
    private Knjiga knjiga;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "uporabnik.id") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
    private Uporabnik uporabnik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }
}