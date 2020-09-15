package org.ensaf.simpleCinema.repositories;

import org.ensaf.simpleCinema.resources.Film;
import org.ensaf.simpleCinema.resources.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film,Long> {

}
