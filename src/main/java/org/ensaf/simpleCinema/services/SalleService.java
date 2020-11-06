package org.ensaf.simpleCinema.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ensaf.simpleCinema.models.CineRequestForm;
import org.ensaf.simpleCinema.models.SalleRequestModel;
import org.ensaf.simpleCinema.repositories.CinemaRepository;
import org.ensaf.simpleCinema.repositories.SalleRepository;
import org.ensaf.simpleCinema.resources.Cinema;
import org.ensaf.simpleCinema.resources.Salle;
import org.ensaf.simpleCinema.resources.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private CinemaRepository cinemaRepository;

    public Salle addSalle(String s) throws Exception {
        Salle salle = new Salle();


        SalleRequestModel salleForm = new ObjectMapper().readValue(s, SalleRequestModel.class);
        Cinema cinema = cinemaRepository.findById(salleForm.getCinema()).get();

        salle.setName(salleForm.getName());
        salle.setNbPlaces(salleForm.getNbPlaces());
        salle.setCinema(cinema);

        salleRepository.save(salle);

        return salle;
    }
}
