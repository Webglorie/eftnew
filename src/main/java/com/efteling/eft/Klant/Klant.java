package com.efteling.eft.Klant;

import com.efteling.eft.Ticket.Ticket;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "klant")
public class Klant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "naam")
    private String naam;

    @Column(name = "leeftijd")
    private int leeftijd;

    @Column(name = "lengte")
    private int lengte;

    @Column(name = "voorkeur_eten")
    private int voorkeurEten;

    @Column(name = "hev_ziekten")
    private boolean hevZiekten;

    @OneToMany
    @JoinColumn(name = "klant_id")
    private Set<Ticket> tickets = new HashSet<>();

    public Klant(){

    }

    public Klant(String naam, int leeftijd, int lengte, int voorkeurEten, boolean hevZiekten) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.lengte = lengte;
        this.voorkeurEten = voorkeurEten;
        this.hevZiekten = hevZiekten;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getVoorkeurEten() {
        return voorkeurEten;
    }

    public void setVoorkeurEten(int voorkeurEten) {
        this.voorkeurEten = voorkeurEten;
    }

    public boolean isHevZiekten() {
        return hevZiekten;
    }

    public void setHevZiekten(boolean hevZiekten) {
        this.hevZiekten = hevZiekten;
    }

    @Override
    public String toString() {
        return "Klant{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", leeftijd=" + leeftijd +
                ", lengte=" + lengte +
                ", voorkeurEten=" + voorkeurEten +
                ", hevZiekten=" + hevZiekten +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klant klant = (Klant) o;

        return id != null ? id.equals(klant.id) : klant.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
