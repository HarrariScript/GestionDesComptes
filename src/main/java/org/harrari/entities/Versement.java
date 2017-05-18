package org.harrari.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Nobody on 5/10/2017.
 */
@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }

    public Versement() {
        super();
    }
}
