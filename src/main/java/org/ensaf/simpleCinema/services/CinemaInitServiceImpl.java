package org.ensaf.simpleCinema.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.ensaf.simpleCinema.repositories.AppRoleRepository;
import org.ensaf.simpleCinema.repositories.AppUserRepository;
import org.ensaf.simpleCinema.repositories.CategoryRepository;
import org.ensaf.simpleCinema.repositories.CinemaRepository;
import org.ensaf.simpleCinema.repositories.FilmRepository;
import org.ensaf.simpleCinema.repositories.PlaceRepository;
import org.ensaf.simpleCinema.repositories.ProjectionRepository;
import org.ensaf.simpleCinema.repositories.SalleRepository;
import org.ensaf.simpleCinema.repositories.SeanceRepository;
import org.ensaf.simpleCinema.repositories.TicketRepository;
import org.ensaf.simpleCinema.repositories.VilleRepository;
import org.ensaf.simpleCinema.resources.AppRole;
import org.ensaf.simpleCinema.resources.AppUser;
import org.ensaf.simpleCinema.resources.Category;
import org.ensaf.simpleCinema.resources.Cinema;
import org.ensaf.simpleCinema.resources.Film;
import org.ensaf.simpleCinema.resources.Place;
import org.ensaf.simpleCinema.resources.Projection;
import org.ensaf.simpleCinema.resources.Salle;
import org.ensaf.simpleCinema.resources.Seance;
import org.ensaf.simpleCinema.resources.Ticket;
import org.ensaf.simpleCinema.resources.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import net.bytebuddy.utility.RandomString;


@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService {
	@Autowired
	private IAccountService accountService;
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private SalleRepository salleRepository;
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ProjectionRepository projectionRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Override
	public void initUsers() {
		Stream.of("user","admin").forEach(u->{
			AppUser user = new AppUser();
			user.setUsername(u);
			user.setPassword("1234");
			accountService.saveUser(user);
		});
		
	}

	@Override
	public void initRoles() {
		Stream.of("ADMIN","USER").forEach(r->{
			AppRole role = new AppRole();
			role.setRole(r);
			accountService.saveRole(role);
		});
		
	}
	@Override
	public void initRolesToUser() {
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
		
	}
	@Override
	public void initVilles() {
		Stream.of("Guercif","casablanca","Marrakech","Rabat","Fes",
				"Agadir","Tanger","Taza","Mekenes","Sale","Ouajda",
				"Tetouane","Nadour","Laayoun","Dakhla","Taoujtat").forEach(v->{
			Ville ville = new Ville();
			ville.setName(v);
			villeRepository.save(ville);
		});
		
	}

	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(v->{
			Stream.of("MegaRama","iMAX","FOUNOUN","CHAHRAZAD").forEach(c->{
				Cinema cinema = new Cinema();
				cinema.setName(c);
				cinema.setNbSalles(3+(int)(Math.random()*9));
				cinema.setVille(v);
				cinemaRepository.save(cinema);
			});
		});
		
	}

	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(c->{
			for (int i = 0; i < c.getNbSalles(); i++) {
				Salle salle = new Salle();
				salle.setName("salle "+(i+1));
				salle.setCinema(c);
				salle.setNbPlaces(20+(int)(Math.random()*30));
				salleRepository.save(salle);
			}
		});
	}

	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(s->{
			for (int i = 0; i < s.getNbPlaces(); i++) {
				Place place  = new Place();
				place.setNumero(i+1);
				place.setSalle(s);
				placeRepository.save(place);
			}
		});
	}

	@Override
	public void initSeances() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s->{
			try {
				Seance seance = new Seance();
				seance.setHeurDebut(dateFormat.parse(s));
				seanceRepository.save(seance);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void initCategories() {
		Stream.of("Action","Drama","Fiction","Drama").forEach(cat->{
			Category category = new Category();
			category.setName(cat);
			categoryRepository.save(category);
		});
	}
 
	@Override
	public void initFilms() {
		double [] durees = new double[] {1,1.5,2,2.5,3};
		Date date = new Date();
		java.util.List<Category> categories = categoryRepository.findAll();
		Stream.of("Game of Thrones","Viking","Breaking bad","Casablanca","Taitanic",
				"Iron Man","Syper man","Batman").forEach(titre->{
			Film film  = new Film();
			film.setTitre(titre);
			film.setDate_sortie(date);
			film.setDescription(RandomString.make(20));
			film.setDuree(durees[new Random().nextInt(durees.length)]);
			film.setPhoto(titre.replaceAll(" ", "")+".jpg");
			film.setCategory(categories.get(new Random().nextInt(categories.size()) ));
			filmRepository.save(film);
		});
	}

	@Override
	public void initProjections() {
		double[] prices = new double[] {30,50,60,70,90,100};
		java.util.List<Film> films =filmRepository.findAll();
		System.out.println("lenght films"+films.size());
		villeRepository.findAll().forEach(v->{
			v.getCinemas().forEach(c->{
				c.getSalles().forEach(s->{
					int index =new Random().nextInt(films.size());
				
						seanceRepository.findAll().forEach(seance->{
							Projection projection = new Projection();
							projection.setDateProjection(new Date());
							projection.setSalle(s);
							projection.setFilm(films.get(index));
							projection.setPrix(prices[new Random().nextInt(prices.length)]);
							projection.setSeance(seance);
							projectionRepository.save(projection);
						});
					
				});
			});
		});
	}

	@Transactional
	@Override
	public void initTickets() {
		for (Projection p : projectionRepository.findAll())
			p.getSalle().getPlaces().forEach(place -> {
				Ticket ticket = new Ticket();
				ticket.setPlace(place);
				ticket.setPrix(p.getPrix());
				ticket.setProjection(p);
				ticket.setEstReserver(false);
				ticketRepository.save(ticket);
			});
	}

	

	

}
