package univ.fac.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import univ.fac.entities.Equipe;
import univ.fac.entities.Matche;
import univ.fac.entities.Stade;
import univ.fac.repositories.MatchRepository;

@Service
public class MatchService {
	@Autowired  MatchRepository mr;

	public List< Matche> getAllMatchs()  {
	return mr.findAll();
	}
	
	public Matche addMatch( Matche ma)  {
	return mr.save(ma);
	}
	public  Matche updateMatch(Matche ma) {
		return mr.save(ma);
		}
	public void deleteMatch(Long id){
		 mr.deleteById(id);
	}
	
	public List<Matche> getMatchByDate( Date dateMatch ){
		return mr.findByDateMatch(dateMatch);
	}
	public Stade getStadeByMatchId (Long idmatch ){
		Matche ma=mr.findById(idmatch).get();
		return ma.getStade();
	}
	public List<Equipe> getEquipesByMatchId (Long idmatch ){
		Matche ma=mr.findById(idmatch).get();
		List <Equipe> equipes = new ArrayList<>();
		equipes.add(ma.getEquipeDomicile());
		equipes.add(ma.getEquipeExterieur());
		return equipes;
	}
	 @Transactional
	   public void deletePastMatches() {
	        mr.deleteByDateMatchBefore(LocalDate.now());
	    }

}
