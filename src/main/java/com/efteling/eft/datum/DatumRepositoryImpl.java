package com.efteling.eft.datum;

import com.efteling.eft.CrudService;
import com.efteling.eft.Klant.Klant;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Service
public class DatumRepositoryImpl implements CrudService<Datum, Long> {

    public DatumRepositoryImpl(DtmRepository datumRepository) {
        this.datumRepository = datumRepository;
    }

    private final DtmRepository datumRepository;



    @Override
    public Set<Datum> findAll() {
        Set<Datum> datums = new HashSet<>();
        datumRepository.findAll().forEach(datums::add);
        return datums;
    }

    @Override
    public Datum findById(Long id) {
        return datumRepository.findById(id).orElse(new Datum());
    }

    @Override
    public Datum save(Datum datum) {
        return datumRepository.save(datum);
    }

    @Override
    public void deleteById(Long datum) {
        datumRepository.deleteById(datum);
    }
}