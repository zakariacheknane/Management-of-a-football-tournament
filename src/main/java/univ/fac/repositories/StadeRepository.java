package univ.fac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import univ.fac.entities.Stade;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long>{

}
