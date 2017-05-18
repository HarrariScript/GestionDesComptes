package org.harrari.metier;

import org.harrari.dao.ClientRepository;
import org.harrari.dao.CompteRepository;
import org.harrari.entities.Compte;
import org.harrari.entities.CompteCourant;
import org.harrari.entities.CompteEpargne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Nobody on 5/12/2017.
 */
@Service
@Transactional
public class CompteMetierimp implements ICompteMetier {

    @Autowired
    CompteRepository compteRepository;
    @Autowired
    IClientMetier iClientMetier;

    @Override
    public Page<Compte> listeComptesC(long idClient, int page, int size) {

           iClientMetier.consulter(idClient);
           return compteRepository.listeComptes(idClient,new PageRequest(page,size));

    }

    @Override
    public void createCompte(Long codeClient, double soldeDemarage, String type, double decouvert, double taux) {
         if(type.equals("Epargne")){
             CompteEpargne compteEpargne = new CompteEpargne("lol",new Date(),soldeDemarage,iClientMetier.consulter(codeClient),taux);
             compteRepository.save(compteEpargne);
         }
         else if(type.equals("Courant")){
             CompteCourant compteCourant = new CompteCourant("lol",new Date(),soldeDemarage,iClientMetier.consulter(codeClient),decouvert);
             compteRepository.save(compteCourant);
         }
    }
}
