package org.ensaf.simpleCinema.repositories;

import org.ensaf.simpleCinema.resources.Salle;
import org.ensaf.simpleCinema.resources.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
