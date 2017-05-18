package org.harrari.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Nobody on 5/10/2017.
 */
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
    private double taux ;

    public CompteEpargne(String numCompte, Date dateCreation, double solde, Client client, double taux) {
        super(numCompte, dateCreation, solde, client);
        this.taux = taux;
    }

    public CompteEpargne(){
        super();
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

}
