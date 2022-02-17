package com.efteling.eft.Klant;

import com.efteling.eft.CrudService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class KlantRepositoryImpl implements CrudService<Klant, Long> {

    private final KlntRepository klantRepository;

    public KlantRepositoryImpl(KlntRepository ticketRepository) {
        this.klantRepository = ticketRepository;
    }


    @Override
    public Set<Klant> findAll() {
        Set<Klant> klanten = new HashSet<>();
        klantRepository.findAll().forEach(klanten::add);
        return klanten;
    }

    @Override
    public Klant findById(Long id) {
        return klantRepository.findById(id).orElse(new Klant());
    }

    @Override
    public Klant save(Klant ticket) {
        return klantRepository.save(ticket);
    }

    @Override
    public void deleteById(Long ticket) {
        klantRepository.deleteById(ticket);
    }
}