package org.ensaf.simpleCinema.resources;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Category implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 75)
	private String name;

	@OneToMany(mappedBy = "category")
	@JsonProperty(access =Access.WRITE_ONLY)
	private Collection<Film>films;
}
