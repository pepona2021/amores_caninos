
package cl.awakelab.amorescaninos.service;

import java.util.List;

import cl.awakelab.amorescaninos.entity.Caracteristica;

public interface CaracteristicaService {

	public Caracteristica create(Caracteristica caracteristica);
	public Caracteristica edit(Caracteristica caracteristica);
	public Caracteristica findById(long id);
	public List<Caracteristica> findAll();
	public List<Caracteristica> findAllById(List<Long> caractList);
}
