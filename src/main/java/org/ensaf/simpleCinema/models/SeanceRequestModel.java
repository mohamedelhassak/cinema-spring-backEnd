package org.ensaf.simpleCinema.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Timer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeanceRequestModel {
    private Long id;
    private Date heurDebut;
}
