package com.efteling.eft.datum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class DatumController {

    private final DatumRepositoryImpl datumRepositoryImpl;

    @Autowired
    private final DtmRepository datumRepository;

    public DatumController(DatumRepositoryImpl datumRepositoryImpl, DtmRepository datumRepository) {
        this.datumRepositoryImpl = datumRepositoryImpl;
        this.datumRepository = datumRepository;
    }

    public void datumCheck(){

    }

    public void datumBeschikbaarheid(){
        for(int i = 1; i < 20; i++) {
            LocalDate exceedTime = LocalDate.now().plusDays(i);
            String formattedDate = exceedTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.println(i + ": " + formattedDate);
        }
    }


}
