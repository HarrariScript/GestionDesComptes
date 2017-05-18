package org.harrari.metier;

import org.harrari.entities.Client;

/**
 * Created by Nobody on 5/12/2017.
 */
public interface IClientMetier {
    public Client consulter(Long code);
}
