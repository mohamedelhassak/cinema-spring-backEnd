package org.ensaf.simpleCinema.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.ensaf.simpleCinema.models.FilmRequestForm;
import org.ensaf.simpleCinema.repositories.CategoryRepository;
import org.ensaf.simpleCinema.repositories.FilmRepository;
import org.ensaf.simpleCinema.resources.Category;
import org.ensaf.simpleCinema.resources.Film;
import org.ensaf.simpleCinema.services.FilmService;
import org.ensaf.simpleCinema.services.TicketService;
import org.ensaf.simpleCinema.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.util.FileUtil;

@RestController
@RequestMapping("films")
public class FilmRestController{
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FilmService filmService;
	@Autowired
	private UploadService uploadService;

	@PostMapping("/addFilm")
	public Film addFilm(@RequestParam("file") MultipartFile file,
				@RequestParam("film") String film) throws Exception, JsonProcessingException {
		return filmService.addFilm(file,film, (long) -3);
	}

	@PutMapping("/updateFilm/{id}")
	public Film updateFilm(@RequestParam("file") MultipartFile file,
						   @RequestParam("film") String film, @PathVariable Long id) throws Exception, JsonProcessingException {

		return filmService.addFilm(file,film,id);
	}


	@PostMapping("/uploadImage")
	public void addFilmImage(@RequestBody MultipartFile file ) throws Exception {
		
		 uploadService.uploadImage(file);
		
	}

}
