package cl.awakelab.amorescaninos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.amorescaninos.entity.Caracteristica;
import cl.awakelab.amorescaninos.entity.Perfil;
import cl.awakelab.amorescaninos.entity.Raza;
import cl.awakelab.amorescaninos.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	PerfilRepository perfilRepo;
	
	@Override
	public Perfil create(Perfil perfil) {
		return perfilRepo.save(perfil);
	}

	@Override
	public Perfil edit(Perfil perfil) {
		return perfilRepo.save(perfil);
	}

	@Override
	public Perfil findById(long id) {
		return perfilRepo.findById(id).orElse(null);
	}

	@Override
	public List<Perfil> findAll() {
		return perfilRepo.findAll();
	}

	@Override
	public List<Perfil> findByCaracteristicas(List<Caracteristica> caract) {
		return perfilRepo.findByCaracteristicasIn(caract);
	}

	@Override
	public List<Perfil> findByRaza(Raza raza) {
		return perfilRepo.findByRaza(raza);
	}

	@Override
	public List<Perfil> findByEdad(int edad) {
		return perfilRepo.findByEdad(edad);
	}

	@Override
	public List<Perfil> findByGenero(String genero) {
		return perfilRepo.findByGenero(genero);
	}

	@Override
	public List<Perfil> findByMultipleFields(List<Caracteristica> caract, List<Raza> raza,
										int edad, List<String> genero) {
		
		if (edad <= 0) {
			return perfilRepo.findDistinctByCaracteristicasInAndRazaInAndGeneroIn(
			  caract, raza, genero);
		}
		
		return perfilRepo.findDistinctByCaracteristicasInAndRazaInAndEdadAndGeneroIn(
			  caract, raza, edad, genero);
	}

}
