package org.ensaf.simpleCinema.repositories;

import java.util.List;

import org.ensaf.simpleCinema.resources.Cinema;
import org.ensaf.simpleCinema.resources.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville,Long> {
	public Ville  findByName(String name);
}

