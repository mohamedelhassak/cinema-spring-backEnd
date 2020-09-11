package org.ensaf.simpleCinema.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CineRequestForm {
    private Long id;
    private String name;
    private int nbSalles;
    private Long ville;
}
