package org.ensaf.simpleCinema.resources;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Projection(name = "projectionsProj",types = {org.ensaf.simpleCinema.resources.Projection.class})
public interface ProjectionProj {
	Long getId();
	double getPrix();
	Date getDateProjection();
	Salle getSalle();
	Film getFilm();
	Seance getSeance();
	Collection<Ticket> getTickets();
}
