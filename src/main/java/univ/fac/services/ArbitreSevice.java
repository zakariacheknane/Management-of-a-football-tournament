package univ.fac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import univ.fac.entities.Arbitre;
import univ.fac.entities.Matche;
import univ.fac.repositories.ArbitreRepository;
import univ.fac.repositories.MatchRepository;


@Service
public class ArbitreSevice {
	@Autowired ArbitreRepository ar;
	@Autowired  MatchRepository mr;

	public List<Arbitre> getAllArbitre()  {
	return ar.findAll();
	}
	
	public Arbitre addArbitre( Arbitre Arbitre)  {
	return ar.save(Arbitre);
	}
	public Arbitre updateArbitre(Arbitre a) {
		return ar.save(a);
		}
	public List<Matche> getMatchByArbitreId(Long id){
		Arbitre arb=ar.findById(id).get();	
		return mr.findByArbitre(arb);	
	}
	


	public void deleteArbitre(Long id){
		List<Matche> matches=getMatchByArbitreId(id);
		matches.forEach(m->{
			m.setArbitre(null);
		});
		 ar.deleteById(id);
	}

}
