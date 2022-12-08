package com.covertocover.CoverToCover.Modeli;

import java.util.Vector;
import java.util.ArrayList;
import org.hibernate.annotations.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;

@Entity
public class Uporabnik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ime;
    private String priimek;
    private String email;
    private String geslo;

    @OneToMany(mappedBy = "", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Vector<Zbirka> zbirke = new Vector<Zbirka>();

    @OneToMany(mappedBy = "", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Vector<OsebniCilj> osebniCilji = new Vector<OsebniCilj>();

    @OneToMany(mappedBy = "", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Vector<Ocena> ocene = new Vector<Ocena>();

    public void dolociOsebniCilj(double aCas, int aSteviloKnjig) {
        throw new UnsupportedOperationException();
    }

    public void posodobiCilj(Knjiga aKnjiga) {
        throw new UnsupportedOperationException();
    }

    public void ustvariZbirko(Knjiga aKnjiga) {
        throw new UnsupportedOperationException();
    }

    public void dodajOceno(Ocena aOcena) {
        throw new UnsupportedOperationException();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeslo() {
        return geslo;
    }

    public void setGeslo(String geslo) {
        this.geslo = geslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return this.ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }
}
