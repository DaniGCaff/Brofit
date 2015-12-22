package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gmuscular database table.
 * 
 */
@Entity
@Table(name="gmusculares")
@NamedQuery(name="Gmuscular.findAll", query="SELECT g FROM Gmuscular g")
public class Gmuscular implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idGMusculares;

	@Column(length=45)
	private String nombre;

	private int tamano;

	@Column(name="tipo_tren")
	private int tipoTren;

	//bi-directional many-to-one association to Ejercicio
	@OneToMany(mappedBy="gmusculare")
	private List<Ejercicio> ejercicios;

	//bi-directional many-to-many association to Lesione
	@ManyToMany(mappedBy="gmusculares")
	private List<Lesion> lesiones;

	public Gmuscular() {
	}

	public int getIdGMusculares() {
		return this.idGMusculares;
	}

	public void setIdGMusculares(int idGMusculares) {
		this.idGMusculares = idGMusculares;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTamano() {
		return this.tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	public int getTipoTren() {
		return this.tipoTren;
	}

	public void setTipoTren(int tipoTren) {
		this.tipoTren = tipoTren;
	}

	public List<Ejercicio> getEjercicios() {
		return this.ejercicios;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	public Ejercicio addEjercicio(Ejercicio ejercicio) {
		getEjercicios().add(ejercicio);
		ejercicio.setGmusculare(this);

		return ejercicio;
	}

	public Ejercicio removeEjercicio(Ejercicio ejercicio) {
		getEjercicios().remove(ejercicio);
		ejercicio.setGmusculare(null);

		return ejercicio;
	}

	public List<Lesion> getLesiones() {
		return this.lesiones;
	}

	public void setLesiones(List<Lesion> lesiones) {
		this.lesiones = lesiones;
	}

}