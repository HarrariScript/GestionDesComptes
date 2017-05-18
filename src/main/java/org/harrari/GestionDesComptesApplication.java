package org.harrari;

import org.harrari.dao.ClientRepository;
import org.harrari.dao.CompteRepository;
import org.harrari.dao.OperationRepository;
import org.harrari.entities.*;
import org.harrari.metier.IBanqueMetier;
import org.harrari.metier.IClientMetier;
import org.harrari.metier.ICompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Date;

@SpringBootApplication
public class GestionDesComptesApplication implements CommandLineRunner {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    IBanqueMetier iBanqueMetier;
    @Autowired
    IClientMetier iClientMetier;
    @Autowired
    ICompteMetier iCompteMetier;

    public static void main(String[] args) {
        SpringApplication.run(GestionDesComptesApplication.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {
//         Client cl1 = clientRepository.save(new Client("lalal", "lalal.sds@dssd.com"));
//        Client cl2 = clientRepository.save(new Client("Harrari omar ", "omar.harrari@gmail.com"));
//        Client cl3 = clientRepository.save(new Client("moi moi ", "moi.moi@dssd.com"));
//          compteRepository.save(new CompteCourant("lol", new Date(), 19000, cl1, 2000));
//        compteRepository.save(new CompteEpargne("C2", new Date(), 19000, cl2, 12));
//        compteRepository.save(new CompteCourant("C3", new Date(), 19000, cl3, 2000));
//        compteRepository.save(new CompteEpargne("C4", new Date(), 19000, cl3, 12));

//          operationRepository.save(new Retrait(new Date(),500,compteRepository.findOne("C1")));
//        System.out.println( iBanqueMetier.consulterCompte("C1"));
//       iBanqueMetier.listeOperation("C1",0,3).forEach(p-> System.out.println(p));
//          iBanqueMetier.retrait(120,"C2");
//          iBanqueMetier.retrait(540,"C1");
//        try {
//            iBanqueMetier.virement(1,"C1","C2");
//        }catch (RuntimeException e){
//            System.out.println(e.getMessage());
//        }
//         CompteCourant compteCourant = new CompteCourant();
//         compteCourant.getClass().getSimpleName()

//        System.out.println(iClientMetier.consulter(new Long(1)));


//        compteRepository.listeComptes((long) 6, new PageRequest(0,3)).
//                forEach(c-> System.out.println(c));

//        iCompteMetier.createCompte((long) 5,100,"CompteEpargne",0,15);
    }



}
