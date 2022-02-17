package com.efteling.eft.Medewerker;

import com.efteling.eft.CrudService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MedewerkerRepositoryImpl implements CrudService<Medewerker, Long> {

    private final MedRepository repository;

    public MedewerkerRepositoryImpl(MedRepository repository) {
        this.repository = repository;
    }


    @Override
    public Set<Medewerker> findAll() {
        Set<Medewerker> medewerkers = new HashSet<>();
        medewerkers.addAll(repository.findAll());
        return medewerkers;
    }

    @Override
    public Medewerker findById(Long id) {
        return repository.findById(id).orElse(new Medewerker());
    }

    @Override
    public Medewerker save(Medewerker medewerker) {
        return repository.save(medewerker);
    }

    @Override
    public void deleteById(Long medewerker) {
        repository.deleteById(medewerker);
    }
}