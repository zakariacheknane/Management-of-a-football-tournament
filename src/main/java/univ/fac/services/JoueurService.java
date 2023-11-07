package univ.fac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import univ.fac.entities.Joueur;

import univ.fac.repositories.JoueurRepository;

@Service
public class JoueurService {
	@Autowired JoueurRepository jr;

	public List<Joueur> getAllJoueurs()  {
	return jr.findAll();
	}
	
	public Joueur addJoueur( Joueur jo)  {
	return jr.save(jo);
	}
	public Joueur updateJoueur(Joueur jo) {
		return jr.save(jo);
		}
	public void deleteJoueur(Long id){
		 jr.deleteById(id);
	}
	public List<Joueur> getJoueurByPosteAndEquipe(String poste,String nomEquipe){
		return jr.findByPosteAndEquipe_nomEquipe(poste, nomEquipe);
	}
}
