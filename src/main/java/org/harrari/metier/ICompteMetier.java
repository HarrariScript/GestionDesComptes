package org.harrari.metier;

import org.harrari.entities.Compte;
import org.harrari.entities.Operation;
import org.springframework.data.domain.Page;

import java.util.Date;

/**
 * Created by Nobody on 5/12/2017.
 */
public interface ICompteMetier {

    public Page<Compte> listeComptesC(long idClient , int page , int size);
    public void createCompte(Long codeClient,double soldeDemarage ,String type , double decouvert , double taux);

}
