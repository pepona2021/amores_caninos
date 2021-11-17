package cl.awakelab.amorescaninos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.awakelab.amorescaninos.entity.Raza;

@Repository
public interface RazaRepository extends JpaRepository <Raza,Long>{

}
