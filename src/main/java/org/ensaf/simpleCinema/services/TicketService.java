package org.ensaf.simpleCinema.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.ensaf.simpleCinema.repositories.TicketRepository;
import org.ensaf.simpleCinema.resources.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	public List<Ticket> payerTicket(TicketForm ticketForm) {
		List<Ticket> listTickets = new ArrayList<Ticket>();
		ticketForm.getTickets().forEach(id->{
			Ticket ticket = ticketRepository.findById(id).get();
			ticket.setNomClient(ticketForm.getNomClient());
			ticket.setEstReserver(true);
			ticket.setCodePayement(ticketForm.getCodePayement());
			ticketRepository.save(ticket);
			listTickets.add(ticket);
		});
		
		return listTickets;
		
	}

}


