package org.ensaf.simpleCinema.repositories;

import org.ensaf.simpleCinema.resources.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	public AppUser findByUsername(String username);
	
}
