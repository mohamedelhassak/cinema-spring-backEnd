package org.ensaf.simpleCinema;



import org.ensaf.simpleCinema.resources.Film;
import org.ensaf.simpleCinema.resources.Salle;
import org.ensaf.simpleCinema.resources.Ticket;
import org.ensaf.simpleCinema.services.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class SimpleCinemaApplication  implements CommandLineRunner  {

	@Autowired
	private ICinemaInitService cinemaInitService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
    public static void main(String[] args) {
        SpringApplication.run(SimpleCinemaApplication.class, args);
    }
  
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Film.class,Salle.class,Ticket.class);
		cinemaInitService.initVilles();
		cinemaInitService.initCinemas();
		cinemaInitService.initSalles();
		cinemaInitService.initPlaces();
		cinemaInitService.initSeances();
		cinemaInitService.initCategories();
		cinemaInitService.initFilms();
		cinemaInitService.initProjections();
		cinemaInitService.initTickets();
    }

}
