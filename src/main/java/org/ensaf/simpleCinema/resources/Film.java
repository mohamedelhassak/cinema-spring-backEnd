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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data  @NoArgsConstructor @AllArgsConstructor
public class Film implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String titre;
	@Temporal(TemporalType.DATE)
	private Date date_sortie;
	private String description;
	private String realisateur;
	private double duree;
	private String photo;	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "film")
	@JsonProperty(access = Access.WRITE_ONLY)
	 private Collection<Projection> projections;
	
	
	
	
}
