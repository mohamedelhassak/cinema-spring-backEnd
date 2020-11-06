package org.ensaf.simpleCinema.services;

import org.ensaf.simpleCinema.models.RegisterForm;
import org.ensaf.simpleCinema.resources.AppRole;
import org.ensaf.simpleCinema.resources.AppUser;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAccountService {
	AppUser register(RegisterForm userForm);
	AppUser saveUser(AppUser user);
	AppRole saveRole(AppRole role);
	void addRoleToUser(String username, String role);
	AppUser findUserByUsername(String username);


}
