package org.ensaf.simpleCinema.resources;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Projection(name = "ticketsProj",types = Ticket.class)
public interface TicketProjection {
	Long getId();
	String getNomClient();
	double getprix();
	Integer getCodePayement();
	boolean getEstReserver();
	Place getPlace();
}
