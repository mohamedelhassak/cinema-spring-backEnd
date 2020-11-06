package org.ensaf.simpleCinema.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "filmsProj",types = Film.class)
public interface FilmProj {
    Long getId();
    String getTitre();
    String getPhoto();
    String getRealisateur();
    double getDuree();
    Date getDate_sortie();
    String getDescription();
    Category getCategory();
}
