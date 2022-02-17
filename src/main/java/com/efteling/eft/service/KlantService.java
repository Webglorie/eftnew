package com.efteling.eft.service;

import com.efteling.eft.Klant.Klant;
import com.efteling.eft.repositories.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("klantService")
public class KlantService {

    private KlantRepository klantRepository;

    @Autowired
    public KlantService(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    public void saveKlant(Klant klant) {
        klantRepository.save(klant);
    }
}
