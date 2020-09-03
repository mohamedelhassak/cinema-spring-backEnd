package org.ensaf.simpleCinema.web;


import org.ensaf.simpleCinema.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
