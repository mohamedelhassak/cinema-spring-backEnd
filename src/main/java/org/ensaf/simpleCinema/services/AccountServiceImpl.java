package org.ensaf.simpleCinema.services;

import org.ensaf.simpleCinema.models.RegisterForm;
import org.ensaf.simpleCinema.repositories.AppRoleRepository;
import org.ensaf.simpleCinema.repositories.AppUserRepository;
import org.ensaf.simpleCinema.resources.AppRole;
import org.ensaf.simpleCinema.resources.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired 
	private AppUserRepository appUserRepository;
	@Autowired 
	private AppRoleRepository appRoleRepository;

	@Override
	public AppUser register(RegisterForm userForm) {
		if(!userForm.getPassword().equals(userForm.getRepassword())) {
			throw new RuntimeException("You must confirm your password");
		}

		AppUser u = findUserByUsername(userForm.getUsername());
		if(u!=null) {
			throw new RuntimeException("this user already exists");
		}

		AppUser user = new AppUser();
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		saveUser(user);
		addRoleToUser(userForm.getUsername(), "USER");
		return user;
	}

	@Override
	public AppUser saveUser(AppUser user) {

		String hashPW  =bCryptPasswordEncoder.encode(user.getPassword());	
		user.setPassword(hashPW);
		return appUserRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleNmae) {
		AppRole role =appRoleRepository.findByRole(roleNmae);
		AppUser user =appUserRepository.findByUsername(username);
		user.getRoles().add(role);
	}

	@Override
	public AppUser findUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}



}
