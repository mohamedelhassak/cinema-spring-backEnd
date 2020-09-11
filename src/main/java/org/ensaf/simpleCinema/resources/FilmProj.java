package org.ensaf.simpleCinema.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "filmsProj",types = Film.class)
public interface FilmProj {
    public Long getId();
    public String getTitre();
    public String getPhoto();
    public String getRealisateur();
    public double getDuree();
    public Date getDate_sortie();
    public String getDescription();
    public Category getCategory();
}
