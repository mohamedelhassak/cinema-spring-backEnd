package org.ensaf.simpleCinema.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ensaf.simpleCinema.models.SalleRequestModel;
import org.ensaf.simpleCinema.models.SeanceRequestModel;
import org.ensaf.simpleCinema.repositories.SeanceRepository;
import org.ensaf.simpleCinema.resources.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/seances")
public class SeanceRestController {
    @Autowired
    private SeanceRepository seanceRepository;

    @PostMapping("/addSeance")
    public Seance addSeance(@RequestParam("seance") String s) throws JsonProcessingException {
        SeanceRequestModel seanceForm = new ObjectMapper().readValue(s,SeanceRequestModel.class);
        Seance seance = new Seance();
        System.out.println(seanceForm.getHeurDebut());
        seance.setHeurDebut(seanceForm.getHeurDebut());
        seanceRepository.save(seance);

        return seance;
    }
}
