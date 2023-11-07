package univ.fac.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idEquipe;
	String nomEquipe;
	String pays;
	@OneToMany(mappedBy = "equipe" )
	@JsonIgnore
	List<Joueur> joueurs;
	
    @OneToMany(mappedBy = "equipeDomicile")
    @JsonIgnore
    private List<Matche> matchesEnDomicile;

    @OneToMany(mappedBy = "equipeExterieur")
    @JsonIgnore
    private List<Matche> matchesEnExterieur;


	
}
