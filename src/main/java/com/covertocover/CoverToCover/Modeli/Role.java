package com.covertocover.CoverToCover.Modeli;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naziv;
    @ManyToMany(mappedBy = "roles")
    private Collection<Uporabnik> uporabniki;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public Role(String name) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Collection<Uporabnik> getUporabniki() {
        return uporabniki;
    }

    public void setUporabniki(Collection<Uporabnik> uporabniki) {
        this.uporabniki = uporabniki;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}
