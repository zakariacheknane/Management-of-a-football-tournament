package univ.fac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import univ.fac.entities.Matche;
import univ.fac.entities.Stade;
import univ.fac.repositories.MatchRepository;
import univ.fac.repositories. StadeRepository;

@Service
public class StadeService {
	@Autowired  StadeRepository sr;
	@Autowired  MatchRepository mr;

	public List< Stade> getAllStades()  {
	return sr.findAll();
	}
	
	public  Stade addStade( Stade st)  {
	return sr.save(st);
	}
	public  Stade updateStade(Stade st) {
		return sr.save(st);
		}
	public List<Matche> getMatchByStadeId(Long id){
		Stade st=sr.findById(id).get();	
		return mr.findByStade(st);	
	}
	

	public void deleteStade(Long id){
		List<Matche> matches=getMatchByStadeId(id);
		matches.forEach(m->{
			m.setStade(null);
		});
		 sr.deleteById(id);
	}
}
