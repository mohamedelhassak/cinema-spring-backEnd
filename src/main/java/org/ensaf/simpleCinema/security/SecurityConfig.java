package org.ensaf.simpleCinema.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private  UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

		  auth.userDetailsService(userDetailsService)
		  	.passwordEncoder(bCryptPasswordEncoder);
	}
	
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		
		// don't create session
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
//		.antMatchers("/register/**","/login/**").permitAll()
		.antMatchers(HttpMethod.DELETE,"/films/**","/categories/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.GET,"/films/**","/categories/**").hasAuthority("ADMIN")
		.anyRequest().permitAll()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilterBefore(new JWTAuthorizedFilter(),
		UsernamePasswordAuthenticationFilter.class);
	}
	
	
}
