package univ.fac.Controlles;

import java.sql.Date;
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
import univ.fac.entities.Matche;
import univ.fac.entities.Stade;
import univ.fac.services.MatchService;

@RestController
public class MatchAPI {
@Autowired MatchService ms;
	
	@GetMapping("matches")
	public List<Matche> getAllMatches(){
		return ms.getAllMatchs();
		}
	@PostMapping("matches")
	public Matche addMatch(@RequestBody Matche ma){
		return  ms.addMatch(ma);
	}
	@PutMapping("matches")
	public Matche updateMatch(@RequestBody Matche ma) {
		return ms.updateMatch(ma);
		}
	@DeleteMapping("matches/{id}")
	public void deleteMatch(@PathVariable Long id){
		 ms.deleteMatch(id);
	}
	@GetMapping("matches/Date/{dateMatch}")
	public List<Matche> getMatchByDate(@PathVariable Date dateMatch ){
		return ms.getMatchByDate(dateMatch);
	}
	@GetMapping("matches/{idmatch}/stade")
	public Stade getStadeByMatchId (@PathVariable Long idmatch ){
		return ms.getStadeByMatchId(idmatch);
	}
	@GetMapping("matches/{idmatch}/equipes")
	public List<Equipe> getEquipesByMatchId (@PathVariable Long idmatch ){
		return ms.getEquipesByMatchId(idmatch);
	}
	@DeleteMapping("matches/Passes")
	  public void deletePastMatches() {
	        ms.deletePastMatches();
	    }
	}

