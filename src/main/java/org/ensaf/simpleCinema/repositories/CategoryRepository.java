package org.ensaf.simpleCinema.repositories;

import org.ensaf.simpleCinema.resources.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category,Long> {
	public Category findByName(String name);
	
}
