package univ.fac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import univ.fac.entities.Equipe;
import univ.fac.entities.Joueur;
import univ.fac.entities.Matche;

import univ.fac.repositories.EquipeRepository;
import univ.fac.repositories.JoueurRepository;
import univ.fac.repositories.MatchRepository;

@Service
public class EquipeService {
	@Autowired EquipeRepository er;
	@Autowired JoueurRepository jr;
	@Autowired  MatchRepository mr;


	public List<Equipe> getAllEquipes()  {
	return er.findAll();
	}
	
	public Equipe addEquipe( Equipe eq)  {
	return er.save(eq);
	}
	public Equipe updateEquipe(Equipe eq) {
		return er.save(eq);
		}
	
	public List<Joueur> getJoueurByEquipeId(Long id){
		Equipe eq=er.findById(id).get();	
		return jr.findByEquipe(eq);	
	}
	public List<Matche> getMatchByEquipe_domId(Long id){
		Equipe eq=er.findById(id).get();	
		return mr.findByEquipeDomicile(eq);	
	}
	public List<Matche> getMatchByEquipe_exId(Long id){
		Equipe eq=er.findById(id).get();	
		return mr.findByEquipeExterieur(eq);	
	}
	
	public void deleteEquipe(Long id){
		List<Joueur> joueurs=getJoueurByEquipeId(id);
		joueurs.forEach(j->{
			j.setEquipe(null);
		});
		List<Matche> matchesdom=getMatchByEquipe_domId(id);
		matchesdom.forEach(md->{
			md.setEquipeDomicile(null);
		});
		List<Matche> matchesext=getMatchByEquipe_exId(id);
		matchesext.forEach(me->{
			me.setEquipeExterieur(null);
		});
		 er.deleteById(id);
	}
	public List<Equipe> getEquipeByPays(String nompays ){
		return er.findByPays(nompays);
	}
    public List<Joueur> getJoueursByEquipeNom(String nomequipe) {
        Equipe equipe = er.findByNomEquipe( nomequipe);
      return equipe.getJoueurs();
    }




}
