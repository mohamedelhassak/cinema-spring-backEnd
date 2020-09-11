package org.ensaf.simpleCinema.repositories;

import org.ensaf.simpleCinema.resources.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	public AppUser findByUsername(String username);
	
}
