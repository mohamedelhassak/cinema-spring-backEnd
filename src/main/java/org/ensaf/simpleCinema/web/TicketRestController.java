package org.ensaf.simpleCinema.web;


import java.util.List;


import org.ensaf.simpleCinema.resources.Ticket;
import org.ensaf.simpleCinema.models.TicketForm;
import org.ensaf.simpleCinema.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
public class TicketRestController {
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/payerTickets")
	public List<Ticket> payerTicket(@RequestBody TicketForm ticketForm) {
		return ticketService.payerTicket(ticketForm);
		
	}
}


