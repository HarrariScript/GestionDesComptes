package org.harrari.dao;

import org.harrari.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nobody on 5/10/2017.
 */
public interface ClientRepository extends JpaRepository<Client,Long> {

}
