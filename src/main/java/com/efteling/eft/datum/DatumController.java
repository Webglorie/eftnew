package com.efteling.eft.datum;

import com.efteling.eft.Klant.Klant;
import com.efteling.eft.Ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.stream.Location;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.efteling.eft.Medewerker.MedewerkerController.ANSI_GREEN;
import static com.efteling.eft.Medewerker.MedewerkerController.ANSI_RESET;

@Controller
public class DatumController {

    private final DatumRepositoryImpl datumRepositoryImpl;
    public int stopCount = 20;

    @Autowired
    private final DtmRepository datumRepository;

    public DatumController(DatumRepositoryImpl datumRepositoryImpl, DtmRepository datumRepository) {
        this.datumRepositoryImpl = datumRepositoryImpl;
        this.datumRepository = datumRepository;
    }

    public void datumCheck(){

    }
    public void datumBeschikbaarheid(){
        ArrayList<Datum> list = datumRepository.findAll();
        System.out.println(ANSI_GREEN + "-------------------------- Beschikbare Datums  -----------------------------" + ANSI_RESET);
        System.out.println("           De onderstaande datum zijn momenteel nog beschikbaar.                         ");
        System.out.println("                          Kies een eerst een datum.                                      ");
        System.out.println(ANSI_GREEN + "----------------------------------------------------------------------------" + ANSI_RESET);
        showDatums(stopCount);

        }

    public void showDatums(int stopCount){
        ArrayList<Datum> list = datumRepository.findAll();
        int startCount = 0;
        boolean runCounting = true;
        for (Datum datum : list){
            if (runCounting) {
                startCount++;
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String strDate = dateFormat.format(datum.getDatum());

                System.out.println(strDate + " - (Nog " + datum.getBeschikbareTickets() + " tickets beschikbaar)");
            }
            if (startCount >= stopCount) {
                runCounting = false;
            }
        }
        System.out.println("Wilt u meer datums zien?");
        System.out.println("Opties:\n1: Ja\n2: Nee");
        Scanner nameScanner = new Scanner(System.in);
        System.out.println("Keuze:");
        String meerDatums = nameScanner.nextLine();
        if (meerDatums.equals("1")){
            this.stopCount = this.stopCount + 20;
            showDatums(this.stopCount);
        }
    }


}
