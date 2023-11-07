package univ.fac.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.entities.Equipe;



@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	public List<Equipe> findByPays(String nompays);
	public Equipe findByNomEquipe(String nom);
	
}
