package org.harrari.metier;

import org.harrari.dao.CompteRepository;
import org.harrari.dao.OperationRepository;
import org.harrari.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Nobody on 5/10/2017.
 */

@Service
@Transactional
public class BanqueMetierImp implements IBanqueMetier {
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    OperationRepository operationRepository;
    @Override
    public Compte consulterCompte(String codeCompte) {
       Compte compte = compteRepository.findOne(codeCompte);
        if (compte==null) throw new RuntimeException("Compte introuvable");
       return compte;
    }

    @Override
    public void verser(double montant, String code_compte) {
        Compte compte = consulterCompte(code_compte);
        Versement versement = new Versement(new Date(),montant,compte);
        compte.setSolde(compte.getSolde()+montant);
        compteRepository.save(compte);
        operationRepository.save(versement);

    }

    @Override
    public void retrait(double montant, String code_compte) {
       Compte compte = consulterCompte(code_compte);
       double facilite = 0 ;
       if (compte instanceof CompteCourant)  facilite =  ((CompteCourant) compte).getDecouvert();
       if (facilite+compte.getSolde()<montant) throw  new RuntimeException("Solde insufisant");
       Retrait retrait = new Retrait(new Date(),montant,compte);
       compte.setSolde(compte.getSolde()-montant);
       compteRepository.save(compte);
       operationRepository.save(retrait);
    }

    @Override
    public void virement(double montant, String code_compteS, String code_compteD) {
      if((code_compteD.toUpperCase()).equals(code_compteS.toUpperCase())) throw new  RuntimeException("Operation non permise !");
        retrait(montant,code_compteS);
        verser(montant,code_compteD);


    }

    @Override
    public Page<Operation> listeOperation(String code_compte, int page, int size) {
           consulterCompte(code_compte);
           return operationRepository.listOperation(code_compte,new PageRequest(page,size));

    }
}
