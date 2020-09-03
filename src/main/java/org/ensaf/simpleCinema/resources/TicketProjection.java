package org.ensaf.simpleCinema.resources;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Projection(name = "ticketsproj",types = Ticket.class)
public interface TicketProjection {
	public Long getId();
	public String getNomClient();
	public double getprix();
	public Integer getCodePayement();
	public boolean getEstReserver();
	public Place getPlace();
}