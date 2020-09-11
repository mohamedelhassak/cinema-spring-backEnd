package org.ensaf.simpleCinema.web;


import java.io.IOException;

import org.ensaf.simpleCinema.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
public class CinemaRestController {
	

	@Autowired
	UploadService uploadService;

	@GetMapping(path = "/getImageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE )
	public byte[] getImage(@PathVariable Long id) throws Exception {
		return uploadService.getImage(id);
	}
	
	
	

}
