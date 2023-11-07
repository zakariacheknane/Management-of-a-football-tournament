package univ.fac.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.entities.Equipe;
import univ.fac.entities.Joueur;


@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long>{
	public List<Joueur> findByEquipe(Equipe eq);
	public List<Joueur> findByPosteAndEquipe_nomEquipe(String poste,String nomEquipe);
}
