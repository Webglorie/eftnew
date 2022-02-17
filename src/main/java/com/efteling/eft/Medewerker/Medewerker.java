package com.efteling.eft.Medewerker;

import javax.persistence.*;

@Entity
public class Medewerker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "naam")
    private String naam;

    @Column(name = "rang")
    private Integer rang;

    public Medewerker(){

    }

    public Medewerker(String naam, Integer rang) {
        this.naam = naam;
        this.rang = rang;
    }

    public Long getId() {
        return id;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
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

    @Override
    public String toString() {
        return "Medewerker{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                '}';
    }


}
