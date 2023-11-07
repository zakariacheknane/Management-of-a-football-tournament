package univ.fac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.entities.Arbitre;


@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre, Long>{

}
