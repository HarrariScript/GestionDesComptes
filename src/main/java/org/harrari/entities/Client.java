package org.harrari.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


/**
 * Created by Nobody on 5/10/2017.
 */
@Entity
public class Client implements Serializable{
    @Id @GeneratedValue
    private Long code ;
    private String nom;
    private String email;
    @OneToMany(mappedBy ="client",fetch =FetchType.LAZY)
    private Collection<Compte> comptes;

    public Client() {
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public Client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Client{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
