package org.ensaf.simpleCinema.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.ensaf.simpleCinema.resources.Ville;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class VilleTest {
	@Autowired
	private VilleRepository villeRepository;
	@Test
	public void findVilleByIdTest() {
		Ville ville =villeRepository.findByName("Casablanca");
		
		assertThat(ville.getName().equals("Casablanca"));
	}

}
