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

import univ.fac.entities.Joueur;
import univ.fac.services.JoueurService;

@RestController
public class JoueurAPI {
@Autowired JoueurService js;
	
	@GetMapping("joueurs")
	public List<Joueur> getAllJoueurs(){
		return js.getAllJoueurs();
		}
	@PostMapping("joueurs")
	public Joueur addJoueur(@RequestBody Joueur jo){
		return  js.addJoueur(jo);
	}
	@PutMapping("joueurs")
	public Joueur updateJoueur(@RequestBody Joueur jo) {
		return js.updateJoueur(jo);
		}
	@DeleteMapping("joueurs/{id}")
	public void deleteJoueur(@PathVariable Long id){
		 js.deleteJoueur(id);
	}
	@GetMapping("equipe/{nomEquipe}/poste/{poste}")
	public List<Joueur> getJoueurByPosteAndEquipe(@PathVariable String nomEquipe,@PathVariable String poste){
		return js.getJoueurByPosteAndEquipe(poste, nomEquipe);
	}
}
