package cl.awakelab.amorescaninos.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="raza")
@SequenceGenerator(name="raza_id_seq",sequenceName="raza_id_seq")
public class Raza {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "raza_id_seq")
	private Long id;
	
	@Column(name="nombre",length =30, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy="raza",fetch=FetchType.EAGER)
	private Set<Perfil> perfiles;

	public Raza() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Raza(Long id, String nombre, Set<Perfil> perfiles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.perfiles = perfiles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
	
	
}
