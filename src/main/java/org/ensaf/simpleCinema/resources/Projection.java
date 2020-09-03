package org.ensaf.simpleCinema.resources;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 @Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Projection implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Date dateProjection;
	private double prix;
	@ManyToOne
	private Film film;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Salle salle;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Seance seance;
	@OneToMany(mappedBy = "projection")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Ticket> tickets;
	
}
