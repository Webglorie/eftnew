package com.efteling.eft.Medewerker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.concurrent.TimeUnit;


@Controller
public class MedewerkerController {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private final MedewerkerRepositoryImpl medewerkerRepositoryImpl;
    @Autowired private final MedRepository medRepository;

    private String medewerkerNaam;
    private Integer medewerkerRang;

    public MedewerkerController(MedewerkerRepositoryImpl medewerkerRepositoryImpl, MedRepository medRepository) {
        this.medewerkerRepositoryImpl = medewerkerRepositoryImpl;
        this.medRepository = medRepository;
    }

    public boolean createMedewerker() throws InterruptedException {
        System.out.println("Nieuwe medewerker aanmaken");
        Scanner nameScanner = new Scanner(System.in);
        System.out.println("Naam van medewerker:");
        String naam = nameScanner.nextLine();
        Medewerker medewerker = new Medewerker();
        medewerker.setNaam(naam);
        medewerker.setRang(1);
        medewerkerRepositoryImpl.save(medewerker);
        System.out.println(ANSI_GREEN + "Medewerker " + naam + " is aangemaakt!" + ANSI_RESET );
        System.out.println("U gaat nu weer terug naar het menu.");
        TimeUnit.SECONDS.sleep(2);

        return true;
    }
    public boolean loginMedewerker() throws InterruptedException {
       ArrayList <Medewerker> list = medRepository.findAll();
        System.out.println("Medewerkers login");
        System.out.println("Naam van medewerker is ook de loginnaam.");
        Scanner nameScanner = new Scanner(System.in);
        System.out.println("Wat is uw naam:");
        String naam = nameScanner.nextLine();

        for (Medewerker medewerker : list){
            if (medewerker.getNaam().equals(naam)){
                System.out.println(ANSI_GREEN + "Succesvol ingelogd als medewerker " + naam + ANSI_RESET );
                setMedewerkerRang(medewerker.getRang());
                setMedewerkerNaam(medewerker.getNaam());
                TimeUnit.SECONDS.sleep(2);
                return true;
            }
        }
        System.out.println(ANSI_RED + "Medewerker niet gevonden" + ANSI_RESET);
        System.out.println(ANSI_RED + "U gaat terug naar het hoofdmenu." + ANSI_RESET);
        TimeUnit.SECONDS.sleep(2);
        return false;
    }


    public String getMedewerkerNaam() {
        return medewerkerNaam;
    }

    public void setMedewerkerNaam(String medewerkerNaam) {
        this.medewerkerNaam = medewerkerNaam;
    }

    public Integer getMedewerkerRang() {
        return medewerkerRang;
    }

    public void setMedewerkerRang(Integer medewerkerRang) {
        this.medewerkerRang = medewerkerRang;
    }
}
