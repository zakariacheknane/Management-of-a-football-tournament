package univ.fac.Controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import univ.fac.entities.Equipe;
import univ.fac.entities.Joueur;
import univ.fac.services.EquipeService;

@RestController
public class EquipeAPI {
@Autowired EquipeService es;
	
	@GetMapping("equipes")
	public List<Equipe> getAllEquipes(){
		return es.getAllEquipes();
		}
	@PostMapping("equipes")
	public Equipe addEquipe(@RequestBody Equipe eq){
		return  es.addEquipe(eq);
	}
	@PutMapping("equipes")
	public Equipe updateEquipe(@RequestBody Equipe eq) {
		return es.updateEquipe(eq);
		}
	@DeleteMapping("equipes/{id}")
	public void deleteEquipe(@PathVariable Long id){
		 es.deleteEquipe(id);
	}
	@GetMapping("equipes/pays/{nompays}")
	public List<Equipe> getEquipeByPays(@PathVariable String nompays ){
		return es.getEquipeByPays(nompays);
	}
	@GetMapping("equipes/{nomequipe}/joueurs")
	public List<Joueur> getJoueursByEquipeNom(@PathVariable String nomequipe){
		return es.getJoueursByEquipeNom(nomequipe);
	}
	}

