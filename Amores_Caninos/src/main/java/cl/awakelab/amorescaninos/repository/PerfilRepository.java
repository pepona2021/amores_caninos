package cl.awakelab.amorescaninos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import cl.awakelab.amorescaninos.entity.Caracteristica;
import cl.awakelab.amorescaninos.entity.Perfil;
import cl.awakelab.amorescaninos.entity.Raza;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Long>{
	//filtro por raza, caracteristicas,genero//
	List<Perfil> findByCaracteristicasIn(List<Caracteristica> caract);
	List<Perfil> findByRaza(Raza raza);
	List<Perfil> findByEdad(int edad);
	List<Perfil> findByGenero(String genero);
	List<Perfil> findDistinctByCaracteristicasInAndRazaInAndGeneroIn(
			  @Nullable List<Caracteristica> caract,
			  @Nullable List<Raza> raza,
			  @Nullable List<String> genero
	);
	
	
	List<Perfil> findDistinctByCaracteristicasInAndRazaInAndEdadAndGeneroIn(
			  @Nullable List<Caracteristica> caract,
			  @Nullable List<Raza> raza,
			  int edad,
			  @Nullable List<String> genero
			);
}
