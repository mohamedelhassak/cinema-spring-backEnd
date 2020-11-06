package org.ensaf.simpleCinema.resources;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "CinemasProj",types = Cinema.class)
public interface CinemaProj {

    Long getId();
    String getName();
    int getNbSalles();
    Ville getVille();
}
