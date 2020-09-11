package org.ensaf.simpleCinema.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ensaf.simpleCinema.resources.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	@Autowired
	private  BCryptPasswordEncoder bCryptPasswordEncoder;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}



	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
	
		
		try {
			AppUser user = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
			System.out.println(user.getUsername()+user.getPassword());
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
				user.getUsername(),
				user.getPassword()
			));
			
		} catch (Exception e) {
		throw new RuntimeException(e);
		}
		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		
		System.out.println("salutttt");
		User springUser=(User)authResult.getPrincipal();
		String jwtToken=Jwts.builder()
		.setSubject(springUser.getUsername())
		.setExpiration(new
		Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
		.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
		.claim("roles", springUser.getAuthorities())
		.compact();
		response.addHeader(SecurityConstants.HEADER_STRING,
		SecurityConstants.TOKEN_PREFIX+jwtToken);
		
		System.out.println(jwtToken);
		
	}


}
