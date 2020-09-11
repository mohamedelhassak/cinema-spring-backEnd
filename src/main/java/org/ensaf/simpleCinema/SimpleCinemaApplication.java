package org.ensaf.simpleCinema;



import org.ensaf.simpleCinema.resources.*;
import org.ensaf.simpleCinema.services.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebSecurity
@SpringBootApplication
public class SimpleCinemaApplication  implements CommandLineRunner  {

	@Autowired
	private ICinemaInitService cinemaInitService;
	@Autowired
	private  BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
    public static void main(String[] args) {
        SpringApplication.run(SimpleCinemaApplication.class, args);
       
		
    }
  
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
   
	@Override
	public void run(String... args) throws Exception {

		repositoryRestConfiguration.exposeIdsFor(
				Film.class,
				Salle.class,
				Ticket.class,
				Category.class,
				Ville.class,
				Cinema.class);
//		cinemaInitService.initUsers();
//		cinemaInitService.initRoles();
//		cinemaInitService.initRolesToUser();
//		cinemaInitService.initVilles();
//		cinemaInitService.initCinemas();
//		cinemaInitService.initSalles();
//		cinemaInitService.initPlaces();
//		cinemaInitService.initSeances();
//		cinemaInitService.initCategories();
//		cinemaInitService.initFilms();
//		cinemaInitService.initProjections();
//		cinemaInitService.initTickets();
    }

}
