package com.efteling.eft.repositories;

import com.efteling.eft.Klant.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class KlantRepository {

@Autowired private EntityManager entityManager;

    @Transactional
    public void save(Klant klant){
        entityManager.persist(klant);
    }


}
