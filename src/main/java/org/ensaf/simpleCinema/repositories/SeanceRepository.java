package org.ensaf.simpleCinema.repositories;

import org.ensaf.simpleCinema.resources.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface SeanceRepository extends JpaRepository<Seance,Long>{
}
