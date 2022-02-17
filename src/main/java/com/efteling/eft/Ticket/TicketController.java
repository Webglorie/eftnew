package com.efteling.eft.Ticket;

import com.efteling.eft.Medewerker.Medewerker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class TicketController {

    private final TicketRepositoryImpl ticketRepositoryImpl;

    @Autowired
    private final TickRepository ticketRepository;

    public TicketController(TicketRepositoryImpl ticketRepositoryImpl, TickRepository ticketRepository) {
        this.ticketRepositoryImpl = ticketRepositoryImpl;
        this.ticketRepository = ticketRepository;
    }

    public void koopTicket() throws ParseException {
        Ticket ticket = new Ticket();
        ticket.setTicketDate(stringToDate("05/11/2022"));

    }

    public Date stringToDate(String date) throws ParseException {
        Date ticketDate=new SimpleDateFormat("dd/MM/yyyy").parse(date);

        return ticketDate;
    }


}
