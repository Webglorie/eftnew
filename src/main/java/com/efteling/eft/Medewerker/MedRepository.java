package com.efteling.eft.Medewerker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface MedRepository extends CrudRepository<Medewerker, Long> {
    ArrayList<Medewerker> findAll();
}
