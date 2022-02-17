package com.efteling.eft.Klant;

import com.efteling.eft.Medewerker.Medewerker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface KlntRepository extends CrudRepository<Klant, Long> {
    ArrayList<Klant> findAll();
}
