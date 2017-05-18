package org.harrari.metier;

import org.harrari.dao.ClientRepository;
import org.harrari.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nobody on 5/12/2017.
 */
@Service
@Transactional
public class ClientMeiterImp implements IClientMetier {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client consulter(Long code) {
        Client client = clientRepository.findOne(code);
        if (client==null) throw  new RuntimeException("Client introuvable ");
        return client;
    }
}
