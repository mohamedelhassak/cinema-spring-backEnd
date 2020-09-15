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
		return accountService.register(userForm);
	}

}
