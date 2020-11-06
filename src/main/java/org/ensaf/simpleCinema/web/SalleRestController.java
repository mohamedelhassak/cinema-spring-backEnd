package org.ensaf.simpleCinema.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.ensaf.simpleCinema.resources.Salle;
import org.ensaf.simpleCinema.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salles")
public class SalleRestController {
    @Autowired
    private SalleService salleService;
    @PostMapping("/addSalle")
    public Salle addSalle(@RequestParam("salle") String salle) throws Exception {
        return salleService.addSalle(salle);
    }
}
