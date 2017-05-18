package org.harrari.dao;

import org.harrari.entities.Compte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Nobody on 5/10/2017.
 */
public interface CompteRepository extends JpaRepository<Compte,String> {
      @Query("select c from Compte c where c.client.code=:x")
      public Page<Compte> listeComptes(@Param("x") Long code , Pageable pageable);
}
