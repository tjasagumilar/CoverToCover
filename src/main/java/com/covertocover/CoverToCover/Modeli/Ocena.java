package com.covertocover.CoverToCover.Modeli;

import jakarta.persistence.*;
import org.hibernate.annotations.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int ocena;
    private String komentar;
    public Knjiga knjiga;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "uporabnik.id") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
    public Uporabnik uporabnik;

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
}