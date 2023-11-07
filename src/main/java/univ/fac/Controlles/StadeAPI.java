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

import univ.fac.entities.Stade;
import univ.fac.services.StadeService;

@RestController
public class StadeAPI {
@Autowired StadeService ss;
	
	@GetMapping("stades")
	public List<Stade> getAllStades(){
		return ss.getAllStades();
		}
	@PostMapping("stades")
	public Stade addStade(@RequestBody Stade st){
		return  ss.addStade(st);
	}
	@PutMapping("stades")
	public Stade updateStade(@RequestBody Stade st) {
		return ss.updateStade(st);
		}
	@DeleteMapping("stades/{id}")
	public void deleteStade(@PathVariable Long id){
		 ss.deleteStade(id);
	}
}
