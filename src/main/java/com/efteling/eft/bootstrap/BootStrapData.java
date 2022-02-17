package com.efteling.eft.bootstrap;


import com.efteling.eft.Klant.Klant;
import com.efteling.eft.Klant.KlntRepository;
import com.efteling.eft.Medewerker.Medewerker;
import com.efteling.eft.Medewerker.MedRepository;
import com.efteling.eft.Ticket.TickRepository;
import com.efteling.eft.Ticket.Ticket;
import com.efteling.eft.Ticket.TicketController;
import com.efteling.eft.datum.Datum;
import com.efteling.eft.datum.DtmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@Order(value=1)
public class BootStrapData implements CommandLineRunner {

    private final MedRepository repository;
    private final KlntRepository klntRepository;
    private final TickRepository tickRepository;
    private final DtmRepository dtmRepository;
    private final TicketController ticketController;


    public BootStrapData(MedRepository repository, KlntRepository klntRepository, TickRepository tickRepository, DtmRepository dtmRepository, TicketController ticketController) {
        this.repository = repository;
        this.klntRepository = klntRepository;
        this.tickRepository = tickRepository;
        this.dtmRepository = dtmRepository;
        this.ticketController = ticketController;
    }


    @Override
    public void run(String... args) throws Exception {
        Medewerker arjen = new Medewerker("Arjen", 1);
        repository.save(arjen);

        Medewerker piet = new Medewerker("Piet", 1);
        repository.save(piet);

        Medewerker jan = new Medewerker("Jan", 2);
        repository.save(jan);
        System.out.println("Toegevoegd");

        Klant dop = new Klant("Dop", 180, 20, 1, false);
        klntRepository.save(dop);
        Klant vlieg = new Klant("Vlieg", 155, 16, 2, true);
        klntRepository.save(vlieg);
        Klant jasmijn = new Klant("Jasmijn", 160, 40, 2, true);
        klntRepository.save(jasmijn);


        for(int i = 1; i < 20; i++) {
            LocalDate exceedTime = LocalDate.now().plusDays(i);
            String formattedDate = exceedTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Datum datumEen = new Datum(ticketController.stringToDate(formattedDate), 100L);
            dtmRepository.save(datumEen);
        }
        System.out.println("testttt: " + ticketController.stringToDate("12/12/2022"));


        Ticket ticketdopeen = new Ticket(ticketController.stringToDate("05/11/2022"));
        ticketdopeen.setKlant(dop);
        tickRepository.save(ticketdopeen);
        Ticket ticketdoptwee = new Ticket(ticketController.stringToDate("05/11/2022"));
        ticketdoptwee.setKlant(dop);
        tickRepository.save(ticketdoptwee);
        Ticket ticketdopdrie = new Ticket(ticketController.stringToDate("05/11/2022"));
        ticketdopdrie.setKlant(dop);
        tickRepository.save(ticketdopdrie);
        Ticket ticketvlieg = new Ticket(ticketController.stringToDate("07/11/2022"));
        ticketvlieg.setKlant(vlieg);
        tickRepository.save(ticketvlieg);
        Ticket ticketjasmijneen = new Ticket(ticketController.stringToDate("06/11/2022"));
        ticketjasmijneen.setKlant(jasmijn);
        tickRepository.save(ticketjasmijneen);
        Ticket ticketjasmijtwee = new Ticket(ticketController.stringToDate("06/11/2022"));
        ticketjasmijtwee.setKlant(jasmijn);
        tickRepository.save(ticketjasmijtwee);
    }

}
