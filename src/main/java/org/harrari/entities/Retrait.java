package org.harrari.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Nobody on 5/10/2017.
 */
@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {

    public Retrait(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }

    public Retrait() {
        super();
    }


}
