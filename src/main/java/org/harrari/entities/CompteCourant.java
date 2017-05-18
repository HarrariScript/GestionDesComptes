package org.harrari.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Nobody on 5/10/2017.
 */
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

    private double decouvert ;
    public CompteCourant(String numCompte, Date dateCreation, double solde, Client client, double decouvert) {
        super(numCompte, dateCreation, solde, client);
        this.decouvert = decouvert;
    }
    public CompteCourant(){
      super();
    }
    public double getDecouvert() {
        return decouvert;
    }
    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
