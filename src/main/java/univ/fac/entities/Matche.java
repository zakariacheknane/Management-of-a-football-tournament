package univ.fac.entities;

import java.sql.Date;
import java.sql.Time;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Matche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;
Date dateMatch; 
Time HeureMatch;

@ManyToOne
Stade stade;
@ManyToOne
Arbitre arbitre;

@ManyToOne
@JoinColumn(name = "equipe_dom_id")
private Equipe equipeDomicile;

@ManyToOne
@JoinColumn(name = "equipe_ext_id")
private Equipe equipeExterieur;




}




   

