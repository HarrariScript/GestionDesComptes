package org.harrari.web;

import org.harrari.entities.Client;
import org.harrari.entities.Compte;
import org.harrari.entities.Operation;
import org.harrari.metier.IBanqueMetier;
import org.harrari.metier.IClientMetier;
import org.harrari.metier.ICompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Nobody on 5/10/2017.
 */
@Controller
public class BanqueController {
    @Autowired
    IBanqueMetier iBanqueMetier;
    @Autowired
    IClientMetier iClientMetier;
    @Autowired
    ICompteMetier iCompteMetier;

    @RequestMapping(value = "/operations")
    public String index() {
        return "operation";
    }

    @RequestMapping(value = "/consulterCompte", method = RequestMethod.GET)
    public String consulterCompte(Model model,
                                  @RequestParam(name = "codeCompte", defaultValue = "") String code,
                                  @RequestParam(name = "page", defaultValue = "0") int p,
                                  @RequestParam(name = "size", defaultValue = "5") int s) {
        try {
            Compte compte = iBanqueMetier.consulterCompte(code);
            Page<Operation> operationPage = iBanqueMetier.listeOperation(code, p, s);
            int[] pages = new int[operationPage.getTotalPages()];
            model.addAttribute("operations", operationPage.getContent());
            model.addAttribute("pageCourant", p);
            model.addAttribute("size", s);
            model.addAttribute("compte", compte);
            model.addAttribute("pages", pages);
            model.addAttribute("codeCompte", code);
        } catch (RuntimeException e) {
            model.addAttribute("ERROR_Message", e);
        }

        return "operation";
    }

    @RequestMapping(value = "/saveOperations", method = RequestMethod.POST)
    public String saveOperation(Model model, @RequestParam(name = "op") String typeOperation,
                                @RequestParam(name = "codeCompteSource") String codeCompteS,
                                @RequestParam(name = "montant") double montant,
                                @RequestParam(name = "codeCompteDistination") String codeCompteD) {
        try {
            if (typeOperation.equals("VIRE")) {
                iBanqueMetier.virement(montant, codeCompteS, codeCompteD);
            } else if (typeOperation.equals("VERS")) {
                iBanqueMetier.verser(montant, codeCompteS);
            }
            if (typeOperation.equals("RETR")) {
                iBanqueMetier.retrait(montant, codeCompteS);
            }
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/consulterCompte?codeCompte=" + codeCompteS + "&error=" + e.getMessage();
        }

        return "redirect:/consulterCompte?codeCompte=" + codeCompteS;

    }

    @RequestMapping(value = "/operation", method = RequestMethod.POST)
    public String operation() {
        return "operation";
    }

    @RequestMapping(value = "/comptes")
    public String compte() {
        return "compte";
    }

    @RequestMapping(value = "/consulterClient", method = RequestMethod.GET)
    public String consulteClient(Model model, @RequestParam(name = "CodeClient") Long codeClient,
                                 @RequestParam(name = "page", defaultValue = "0") int p,
                                 @RequestParam(name = "size", defaultValue = "5") int s) {
        try {
            Client client;
            client = iClientMetier.consulter(codeClient);
            Page<Compte> compteList = iCompteMetier.listeComptesC(codeClient, p, s);
            int[] pages = new int[compteList.getTotalPages()];
            model.addAttribute("pageCourant", p);
            model.addAttribute("compteList", compteList);
            model.addAttribute("client", client);
            model.addAttribute("pages", pages);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            model.addAttribute("error", ex.getMessage());
        }

        return "compte";
    }

    @RequestMapping(value = "/saveCompte", method = RequestMethod.POST)
    public String saveCompte(Model model, @RequestParam(name = "TypeCompte") String typeCompte ,
                             @RequestParam(name = "taux" ,defaultValue = "0") double taux ,
                             @RequestParam(name = "decouvert" , defaultValue = "0") double decouvert ,
                             @RequestParam(name = "codeClient") Long codeClient ,
                             @RequestParam(name = "MontantDemarage",defaultValue = "0") double soldeDemarage) {

        try{
            iCompteMetier.createCompte(codeClient,soldeDemarage,typeCompte,decouvert,taux);
        }catch(RuntimeException ex){

        }

        return "redirect:/consulterClient?CodeClient="+codeClient;
    }

}
