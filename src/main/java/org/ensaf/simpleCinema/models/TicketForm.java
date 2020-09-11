package org.ensaf.simpleCinema.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TicketForm{
	private String nomClient;
	private int codePayement;
	private List<Long> tickets = new ArrayList<Long>();
}
