package com.covertocover.CoverToCover.Modeli;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import org.hibernate.annotations.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;

@Entity
public class Zbirka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ime;
    private Knjiga knjige;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "uporabnik.id") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
    public Uporabnik uporabnik;

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

    public Knjiga getKnjige() {
        return knjige;
    }

    public void setKnjige(Knjiga knjige) {
        this.knjige = knjige;
    }
}
