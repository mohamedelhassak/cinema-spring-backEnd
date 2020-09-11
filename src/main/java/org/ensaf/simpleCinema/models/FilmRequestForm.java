package org.ensaf.simpleCinema.models;

import java.util.Date;
import org.ensaf.simpleCinema.resources.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class FilmRequestForm {
	private String titre;
	private String description;
	private String realisateur;
	private Long category;
	private Date date_sortie;
	private double duree;

}
