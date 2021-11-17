package cl.awakelab.amorescaninos.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="perfil")
@SequenceGenerator(name="perfil_id_seq",sequenceName="perfil_id_seq")
public class Perfil {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "perfil_id_seq")
	private Long id;
	
	@Column(name="nombre",length =30, nullable = false)
	private String nombre;
	
	@Column(name="genero",length =15, nullable = false)
	private String genero;
	
	@Column(name="edad", nullable = false)
	private int edad;
	
	@Column(name="frase",length =100, nullable = false)
	private String frase;
	
	@Column(name="url_imagen",length =200, nullable = false)
	private String urlimagen;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="raza_id")
	private Raza raza;
	
	@ManyToMany(fetch=FetchType.EAGER, 
			cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinTable(
	 name ="perfil_has_caracteristica",	
	 joinColumns	= @JoinColumn(name="perfil_id"),
	 inverseJoinColumns = @JoinColumn(name="caracteristica_id"))
	private Set<Caracteristica> caracteristicas;

	public Perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perfil(Long id, String nombre, String genero, int edad, String frase, String urlimagen, Raza raza,
			Set<Caracteristica> caracteristicas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.frase = frase;
		this.urlimagen = urlimagen;
		this.raza = raza;
		this.caracteristicas = caracteristicas;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public String getUrlimagen() {
		return urlimagen;
	}

	public void setUrlimagen(String urlimagen) {
		this.urlimagen = urlimagen;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	
	
	
	
}
