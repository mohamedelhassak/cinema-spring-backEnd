package org.ensaf.simpleCinema.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.ensaf.simpleCinema.repositories.FilmRepository;
import org.ensaf.simpleCinema.resources.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UploadService {

	@Autowired
	private FilmRepository filmRepository;
	
	
	public byte[] getImage(Long id) throws Exception {
		Film film = filmRepository.findById(id).get();
		String photoName = film.getPhoto();
		File file = new File(System.getProperty("user.home") + "/cinema-app-spring/images/"+photoName);
		Path path = Paths.get(file.toURI());
		return Files.readAllBytes(path);
	}
}
