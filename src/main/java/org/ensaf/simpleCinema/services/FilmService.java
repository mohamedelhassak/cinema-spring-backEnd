package org.ensaf.simpleCinema.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ensaf.simpleCinema.models.FilmRequestForm;
import org.ensaf.simpleCinema.repositories.CategoryRepository;
import org.ensaf.simpleCinema.repositories.FilmRepository;
import org.ensaf.simpleCinema.resources.Category;
import org.ensaf.simpleCinema.resources.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    public Film addFilm(MultipartFile file,String film ,Long id) throws Exception {
        Film film2 =null ;
        String filename =null;
        if (id!=null){
            film2 =filmRepository.findById(id).get();

        }
        else if (id==null){
            film2 = new Film();
        }

        FilmRequestForm filmForm = new ObjectMapper().readValue(film, FilmRequestForm.class);
        System.out.println("film "+filmForm.getCategory());
        Category category = categoryRepository.findById(filmForm.getCategory()).get();
        if (file!=null){
            filename = file.getOriginalFilename();
            Files.write(Paths.get(System.getProperty("user.home") + "/cinema-app-spring/images/"+filename), file.getBytes());
        }



        film2.setCategory(category);
        film2.setDate_sortie(filmForm.getDate_sortie());
        film2.setDescription((filmForm.getDescription()));
        film2.setDuree(filmForm.getDuree());
        film2.setRealisateur(filmForm.getRealisateur());
        film2.setTitre(filmForm.getTitre());
        if (filename!=null){
            film2.setPhoto(filename);
        }
        filmRepository.save(film2);

        return film2;
    }
}
