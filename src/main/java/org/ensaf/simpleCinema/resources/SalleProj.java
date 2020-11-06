package org.ensaf.simpleCinema.resources;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@org.springframework.data.rest.core.config.Projection(name = "salleProj",types = {org.ensaf.simpleCinema.resources.Salle.class})
public interface SalleProj {
    Long getId();
    String getName();
    int getNbPlaces();
    Cinema getCinema();
}
