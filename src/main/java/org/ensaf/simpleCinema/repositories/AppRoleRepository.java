package org.ensaf.simpleCinema.repositories;

import org.ensaf.simpleCinema.resources.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
 public AppRole findByRole(String role);
 
}
