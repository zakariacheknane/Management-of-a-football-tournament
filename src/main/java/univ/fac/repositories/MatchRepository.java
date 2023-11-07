package univ.fac.repositories;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.entities.Arbitre;
import univ.fac.entities.Equipe;
import univ.fac.entities.Stade;

import univ.fac.entities.Matche;

@Repository
public interface MatchRepository extends JpaRepository<Matche, Long> {
	public List<Matche> findByArbitre(Arbitre ar);
	public List<Matche> findByStade(Stade st);
	public List<Matche> findByEquipeDomicile(Equipe eq);
	public List<Matche> findByEquipeExterieur(Equipe eq);
	public List<Matche> findByDateMatch(Date datematch);
	public void deleteByDateMatchBefore(LocalDate localDate);
	
}
