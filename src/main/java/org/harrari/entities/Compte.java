package org.harrari.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Nobody on 5/10/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Compte",
        discriminatorType = DiscriminatorType.STRING,
        length = 2)
public abstract class Compte implements Serializable {
    @Id
    private String numCompte;
    private Date dateCreation ;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "Code_client")
    private Client client;
    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;

    public Compte() {

    }

    public Compte(String numCompte, Date dateCreation, double solde, Client client) {
        this.numCompte = numCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "numCompte='" + numCompte + '\'' +
                ", dateCreation=" + dateCreation +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }
}
