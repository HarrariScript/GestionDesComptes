package org.harrari.metier;

import org.harrari.entities.Compte;
import org.harrari.entities.Operation;
import org.springframework.data.domain.Page;

/**
 * Created by Nobody on 5/10/2017.
 */
public interface IBanqueMetier  {
    public Compte consulterCompte(String codeCompte) throws RuntimeException;
    public void verser(double montant , String code_compte);
    public void retrait(double montant , String code_compte) throws RuntimeException;
    public void virement(double montant , String code_compteS , String code_compteD) throws RuntimeException;
    public Page<Operation> listeOperation(String code_compte,int page ,int size);

}
