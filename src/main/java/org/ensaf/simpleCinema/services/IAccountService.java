package org.ensaf.simpleCinema.services;

import org.ensaf.simpleCinema.models.RegisterForm;
import org.ensaf.simpleCinema.resources.AppRole;
import org.ensaf.simpleCinema.resources.AppUser;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAccountService {
	public AppUser register(RegisterForm userForm);
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String role);
	public AppUser findUserByUsername(String username);


}
