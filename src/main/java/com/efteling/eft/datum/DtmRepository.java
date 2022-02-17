package com.efteling.eft.datum;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DtmRepository extends CrudRepository<Datum, Long> {
    ArrayList<Datum> findAll();
}
