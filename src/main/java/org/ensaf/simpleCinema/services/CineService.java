package org.ensaf.simpleCinema.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ensaf.simpleCinema.models.CineRequestForm;
import org.ensaf.simpleCinema.models.FilmRequestForm;
import org.ensaf.simpleCinema.repositories.CinemaRepository;
import org.ensaf.simpleCinema.repositories.VilleRepository;
import org.ensaf.simpleCinema.resources.Category;
import org.ensaf.simpleCinema.resources.Cinema;
import org.ensaf.simpleCinema.resources.Film;
import org.ensaf.simpleCinema.resources.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class CineService {
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;

    public Cinema addCine( String cine , Long id) throws Exception {

        Cinema cinema  =null ;
        if (id!=null){
            cinema =cinemaRepository.findById(id).get();

        }
        else if (id==null){
            cinema = new Cinema();
        }

        CineRequestForm cineForm = new ObjectMapper().readValue(cine, CineRequestForm.class);
        Ville ville = villeRepository.findById(cineForm.getVille()).get();

        cinema.setName(cineForm.getName());
        cinema.setNbSalles(cineForm.getNbSalles());
        cinema.setVille(ville);

        cinemaRepository.save(cinema);

        return cinema;
    }
}
