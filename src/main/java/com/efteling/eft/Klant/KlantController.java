package com.efteling.eft.Klant;

import com.efteling.eft.Medewerker.Medewerker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.efteling.eft.Medewerker.MedewerkerController.*;

@Controller
public class KlantController {

    private final KlantRepositoryImpl klantRepositoryImpl;

    @Autowired
    private final KlntRepository klantRepository;

    public KlantController(KlantRepositoryImpl klantRepositoryImpl, KlntRepository klantRepository) {
        this.klantRepositoryImpl = klantRepositoryImpl;
        this.klantRepository = klantRepository;
    }

    public void nieuweKlant() throws ParseException {
        Klant klant = new Klant();


    }
    public boolean klantCheck() throws InterruptedException {
        ArrayList<Klant> list = klantRepository.findAll();
        System.out.println(ANSI_GREEN + "---------------------------- Klanten Login  --------------------------------" + ANSI_RESET);
        System.out.println("                        Om een ticket te kunnen kopen moet u ingelogd zijn.                           ");
        System.out.println("                                Inloggen gaat op basis van uw voornaam.                               ");
        System.out.println(ANSI_GREEN + "----------------------------------------------------------------------------" + ANSI_RESET);
        Scanner nameScanner = new Scanner(System.in);
        System.out.println("Wat is uw voornaam:");
        String naam = nameScanner.nextLine();

        for (Klant klant : list){
            if (klant.getNaam().equals(naam)){
                System.out.println(ANSI_GREEN + "Succesvol ingelogd als klant " + naam + ANSI_RESET );
                TimeUnit.SECONDS.sleep(2);
                return true;
            }
        }
        System.out.println(ANSI_RED + "Klant niet gevonden" + ANSI_RESET);
        System.out.println(ANSI_RED + "U gaat terug naar het hoofdmenu." + ANSI_RESET);
        TimeUnit.SECONDS.sleep(2);
        return false;
    }


}
