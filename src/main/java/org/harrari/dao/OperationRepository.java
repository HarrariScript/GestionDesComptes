package org.harrari.dao;

import org.harrari.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Nobody on 5/10/2017.
 */
public interface OperationRepository extends JpaRepository<Operation,Long> {
     @Query("select o from Operation o where o.compte.numCompte=:x order by o.dateOperation desc ")
     public Page<Operation> listOperation(@Param("x") String codeCompte , Pageable pageable);
}
