package com.efteling.eft.datum;


import com.efteling.eft.Ticket.Ticket;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "datum")
public class Datum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "datum")
    Date datum;

    @Column(name = "beschikbareTickets")
    Long beschikbareTickets;

    @OneToMany
    @JoinColumn(name = "datum_id")
    private Set<Ticket> tickets = new HashSet<>();

    public Datum() {

    }

    public Datum(Date datum, Long beschikbareTickets) {
        this.datum = datum;
        this.beschikbareTickets = beschikbareTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Long getBeschikbareTickets() {
        return beschikbareTickets;
    }

    public void setBeschikbareTickets(Long beschikbareTickets) {
        this.beschikbareTickets = beschikbareTickets;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "id=" + id +
                ", datum=" + datum +
                ", beschikbareTickets=" + beschikbareTickets +
                ", tickets=" + tickets +
                '}';
    }
}
