package cl.awakelab.amorescaninos.service;

import java.util.List;

import cl.awakelab.amorescaninos.entity.Raza;

public interface RazaService {

	
	public Raza create(Raza raza);
	public Raza edit(Raza raza);
	public Raza findById(long id);
	public List<Raza> findAll();
}
