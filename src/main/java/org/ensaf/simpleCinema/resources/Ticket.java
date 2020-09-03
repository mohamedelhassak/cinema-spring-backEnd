package org.ensaf.simpleCinema.resources;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ticket implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nomClient;
	private double prix;
	@Column(unique = false,nullable = true)
	private Integer codePayement;
	private boolean estReserver;
	@ManyToOne
	private Place place;
	@ManyToOne
	
	private Projection projection;
}
