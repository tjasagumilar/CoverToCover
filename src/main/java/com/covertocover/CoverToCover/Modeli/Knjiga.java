package com.covertocover.CoverToCover.Modeli;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Vector;


@Entity
public class Knjiga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naslov;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "avtor.id") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
    private Avtor avtor;
    private int letoIzdaje;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "zanr.id") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
    private Zanr zanr;
    private int steviloStrani;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }


    public int getLetoIzdaje() {
        return letoIzdaje;
    }

    public void setLetoIzdaje(int letoIzdaje) {

        this.letoIzdaje = letoIzdaje;
    }

    public int getSteviloStrani() {

        return steviloStrani;
    }

    public void setSteviloStrani(int steviloStrani) {

        this.steviloStrani = steviloStrani;
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
}

