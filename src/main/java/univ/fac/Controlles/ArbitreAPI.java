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

import univ.fac.entities.Arbitre;
import univ.fac.services.ArbitreSevice;


@RestController
public class ArbitreAPI {
@Autowired ArbitreSevice as;
	
	@GetMapping("arbitres")
	public List<Arbitre> getAllGroupes(){
		return as.getAllArbitre();
		}
	@PostMapping("arbitres")
	public Arbitre addArbitre(@RequestBody Arbitre a){
		return  as.addArbitre(a);
	}
	@PutMapping("arbitres")
	public Arbitre updateArbitre(@RequestBody Arbitre a) {
		return as.updateArbitre(a);
		}
	@DeleteMapping("arbitres/{id}")
	public void deleteArbitre(@PathVariable Long id){
		 as.deleteArbitre(id);
	}
}
