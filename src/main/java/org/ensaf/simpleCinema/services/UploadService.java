package org.ensaf.simpleCinema.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.ensaf.simpleCinema.repositories.FilmRepository;
import org.ensaf.simpleCinema.resources.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	public void uploadImage(MultipartFile file) throws Exception {
		Files.write(Paths.get(System.getProperty("user.home") + "/cinema-app-spring/images/"),file.getBytes());
	}
}
