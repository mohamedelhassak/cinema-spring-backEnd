package org.ensaf.simpleCinema.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.ensaf.simpleCinema.resources.Cinema;
import org.ensaf.simpleCinema.resources.Film;
import org.ensaf.simpleCinema.services.CineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("cinemas")
public class CineRestController {
    @Autowired
    private CineService cineService;

    @PostMapping("/addCine")
    public Cinema addCine(@RequestParam("cine") String cine) throws Exception {
        return cineService.addCine(cine, null);
    }

    @PutMapping("/updateCine/{id}")
    public Cinema addCine(@RequestParam("cine") String cine,@PathVariable Long id) throws Exception {
        return cineService.addCine(cine, id);
    }
}
