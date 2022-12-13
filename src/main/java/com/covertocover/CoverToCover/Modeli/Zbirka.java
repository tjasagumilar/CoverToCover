package com.covertocover.CoverToCover.Modeli;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.*;

@Entity
public class Zbirka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ime;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "zbirka_knjige",
            joinColumns = { @JoinColumn(name = "zbirka_id") },
            inverseJoinColumns = { @JoinColumn(name = "knjiga_id") })
    public List<Knjiga> knjige;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "uporabnik_id") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
    private Uporabnik uporabnik;

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

    public List<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(Vector<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }


}
