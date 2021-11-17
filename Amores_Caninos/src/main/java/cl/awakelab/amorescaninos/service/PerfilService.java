package cl.awakelab.amorescaninos.service;

import java.util.List;

import cl.awakelab.amorescaninos.entity.Caracteristica;
import cl.awakelab.amorescaninos.entity.Perfil;
import cl.awakelab.amorescaninos.entity.Raza;

public interface PerfilService {

	public Perfil create(Perfil perfil);
	public Perfil edit(Perfil perfil);
	public Perfil findById(long id);
	public List<Perfil> findAll();
	public List<Perfil> findByCaracteristicas(List<Caracteristica> caracteristica);
	public List<Perfil> findByRaza(Raza raza);
	public List<Perfil> findByEdad(int edad);
	public List<Perfil> findByGenero(String genero);
	//buscar por multiples campos//
	public List<Perfil> findByMultipleFields(List<Caracteristica> caract, List<Raza> raza, int edad, List<String> genero);
}
