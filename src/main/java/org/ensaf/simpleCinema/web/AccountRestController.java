package org.ensaf.simpleCinema.web;

import org.ensaf.simpleCinema.models.RegisterForm;
import org.ensaf.simpleCinema.resources.AppUser;
import org.ensaf.simpleCinema.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
	@Autowired
	private IAccountService accountService;
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm) {
		if(!userForm.getPassword().equals(userForm.getRepassword())) {
			throw new RuntimeException("You must confirm your password");
		}
		
		AppUser u = accountService.findUserByUsername(userForm.getUsername());
		if(u!=null) {
			throw new RuntimeException("this user already exists");
		}
		
		AppUser user = new AppUser();
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		accountService.saveUser(user);
		accountService.addRoleToUser(userForm.getUsername(), "USER");
		return user;
	}

}
