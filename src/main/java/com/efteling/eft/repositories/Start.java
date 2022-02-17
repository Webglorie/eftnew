package com.efteling.eft.repositories;

import com.efteling.eft.Klant.KlantController;
import com.efteling.eft.Medewerker.MedewerkerController;
import com.efteling.eft.bootstrap.BootStrapData;
import com.efteling.eft.datum.DatumController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Component
@Order(value=2)
public class Start implements CommandLineRunner {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    @Autowired private MedewerkerController medewerkerController;
    @Autowired private KlantController klantController;
    @Autowired private DatumController datumController;

    @Override
    public void run(String... args) throws Exception {

        int menuPage = menu();
        switch(menuPage){
            case 1:
                if (!klantController.klantCheck()) {
                    run();
                }
                break;
            case 2:
                datumController.datumBeschikbaarheid();
                break;
            case 3:
                System.out.println("Beschikbaarheid");
                break;
            case 4:
                    if (medewerkerController.loginMedewerker()) {
                        medewerkerMenu(medewerkerController.getMedewerkerNaam(), medewerkerController.getMedewerkerRang());
                    } else {
                        run();
                    }
                break;
            case 5:
                if(medewerkerController.createMedewerker()) {
                    run();
                } else {
                    System.out.println("Failed");
                }
                break;
            case 6:
                System.out.println("test 1");
                break;
            default:
                System.out.println("Invalid selection");
                break;

        }
    }
    public int menu() {
        int nextMenu;
            System.out.println("|                 Welkom bij de efteling!                |");
            System.out.println("|           Options:                                     |");
            System.out.println("|        1. Tickets kopen en gekochte tickets            |");
            System.out.println("|        2. Datum beschikbaarheid checken                |");
            System.out.println("|        3. Inchecken                                    |");
            System.out.println("|        4. Medewerker inloggen                          |");
            System.out.println("|        5. Medewerker Aanmaken                          |");
            System.out.println("|        6. Exit                                         |");
            nextMenu = Keyin.inInt("Selecteer een optie: ");

            return nextMenu;

    }
    public int medewerkerMenu(String naam, Integer rang) throws Exception {
        String naamMedewerker = medewerkerController.getMedewerkerNaam();
        String naamRang;
        Integer idRang = medewerkerController.getMedewerkerRang();
        if (idRang.equals(1)) {
            naamRang = "Medewerker";
        } else if (idRang.equals(2)){
            naamRang = "Manager";
        } else {
            naamRang = "Functie niet gevonden";
        }
        int medMenu;
        System.out.println("Welkom terug, " + naamMedewerker + " !");
        System.out.println("Functie: " + naamRang + "");
        System.out.println("Menu opties:");
        System.out.println("1. Bekijk wachtrij statistieken");
        if (idRang.equals(2)) {
            System.out.println("2. Ticket verkoop informatie"); }
        System.out.println("3. Uitloggen");
        medMenu = Keyin.inInt("Selecteer een optie: ");

        switch (medMenu) {
            case 1:
                System.out.println("Wachtrij");
                break;
            case 2:
                if (idRang.equals(2)) {
                    System.out.println("Manager menu");
                } else {
                    System.out.println(ANSI_RED + "---------------------------- Error  --------------------------------" + ANSI_RESET);
                    System.out.println(ANSI_RED + "Een medewerker heeft geen toegang tot de ticket verkoop informatie." + ANSI_RESET);
                    System.out.println(ANSI_RED + "--------------------------------------------------------------------" + ANSI_RESET);
                    TimeUnit.SECONDS.sleep(2);
                    medewerkerMenu(naamMedewerker, idRang);
                }
                break;
            case 3:
                System.out.println("U wordt uitgelogd..");
                run();
                break;

        }
        return medMenu;
    }
    public int klantCheck(Long id, String naam) throws Exception {
        int klntMenu;
        System.out.println("Welkom bij de efteling!");
        System.out.println("Om tickets te kunnen kopen heeft u een account nodig.\n Terugkerende klant? Dan kan u inloggen met uw voornaam.");
        System.out.println("Kies een van de onderstaande opties:");
        System.out.println("1. Klant account aanmaken");
        System.out.println("2. Inloggen op klant account");
        System.out.println("3. Terug naar hoofdmenu");
        klntMenu = Keyin.inInt("Selecteer een optie: ");

        switch (klntMenu) {
            case 1:
                if (klantController.klantCheck()){

                }
                break;
            case 2:

                break;
            case 3:
                System.out.println("U wordt uitgelogd..");
                run();
                break;

        }
        return klntMenu;
    }
class Keyin {

    //*******************************
    //   support methods
    //*******************************
    //Method to display the user's prompt string
    public static void printPrompt(String prompt) {
        System.out.print(prompt + " ");
        System.out.flush();
    }

    //Method to make sure no data is available in the
    //input stream
    public static void inputFlush() {
        int dummy;
        int bAvail;

        try {
            while ((System.in.available()) != 0)
                dummy = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Input error");
        }
    }

    public static String inString() {
        int aChar;
        String s = "";
        boolean finished = false;

        while (!finished) {
            try {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n')
                    finished = true;
                else if ((char) aChar != '\r')
                    s = s + (char) aChar; // Enter into string
            } catch (java.io.IOException e) {
                System.out.println("Input error");
                finished = true;
            }
        }
        return s;
    }

    public static int inInt(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Integer.valueOf(inString().trim()).intValue();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Not an integer");
            }
        }
    }
}
}
