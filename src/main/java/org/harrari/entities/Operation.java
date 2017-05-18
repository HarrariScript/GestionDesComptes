package org.harrari.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nobody on 5/10/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_operation",
        discriminatorType = DiscriminatorType.STRING,
           length = 1)
public abstract class Operation implements Serializable{
    @Id @GeneratedValue
    private Long numOperation;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "Code_compte")
    private Compte compte;

    public Operation(Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }
    public Operation(){

    }

    public Long getNumOperation() {
        return numOperation;
    }

    public void setNumOperation(Long numOperation) {
        this.numOperation = numOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "numOperation=" + numOperation +
                ", dateOperation=" + dateOperation +
                ", montant=" + montant +
                '}';
    }
}
