package cl.awakelab.amorescaninos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.amorescaninos.entity.Raza;
import cl.awakelab.amorescaninos.repository.RazaRepository;

@Service
public class RazaServiceImpl implements RazaService{
	@Autowired
	RazaRepository razaRepo;
	
	@Override
	public Raza create(Raza raza) {
		return razaRepo.save(raza);
	}

	@Override
	public Raza edit(Raza raza) {
		return razaRepo.save(raza);
	}

	@Override
	public Raza findById(long id) {
		return razaRepo.findById(id).orElse(null);
	}

	@Override
	public List<Raza> findAll() {
		return razaRepo.findAll();
	}

}
