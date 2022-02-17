package com.efteling.eft.Ticket;

import com.efteling.eft.Klant.Klant;
import com.efteling.eft.datum.Datum;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "ticketDate")
    private Date ticketDate;

    @Column(name = "ticketIngecheckt")
    private Boolean ticketGebruikt;

    @ManyToOne
    private Klant klant;

    @ManyToOne
    private Datum datum;

    public Ticket(){

    }

    public Ticket(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }


    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Boolean getTicketGebruikt() {
        return ticketGebruikt;
    }

    public void setTicketGebruikt(Boolean ticketGebruikt) {
        this.ticketGebruikt = ticketGebruikt;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketDate=" + ticketDate +
                ", ticketGebruikt=" + ticketGebruikt +
                '}';
    }
}
