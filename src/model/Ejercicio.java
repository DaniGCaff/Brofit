package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ejercicios database table.
 * 
 */
@Entity
@Table(name="ejercicios")
@NamedQueries({
	@NamedQuery(name="Ejercicio.findAll", query="SELECT e FROM Ejercicio e"),
	@NamedQuery(name="Ejercicio.findByGMuscular", query="SELECT e FROM Ejercicio e JOIN e.gmusculare g WHERE g.nombre LIKE ':gmuscular'"),
	@NamedQuery(name="Ejercicio.findByTipo", query="SELECT e FROM Ejercicio e WHERE e.tipoEjercicio = :tipo"),
	@NamedQuery(name="Ejercicio.findByTamano", query="SELECT e FROM Ejercicio e JOIN e.gmusculare g WHERE g.tamano = :tamano"),
	@NamedQuery(name="Ejercicio.findByTren", query="SELECT e FROM Ejercicio e JOIN e.gmusculare g WHERE g.tipoTren = :tren"),
})
public class Ejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idEjercicios;

	private int dificultadTecnica;


	@Column(length=45)
	private String nombre;

	@Column(name="tipo_ejercicio")
	private int tipoEjercicio;
	//Técnica o fuerza
	public enum TipoEjercicio{
		tipoFuerza,tipoTecnica;
	}
	//bi-directional many-to-one association to Gmusculare
	@ManyToOne
	@JoinColumn(name="GMusculares_idGMusculares", nullable=false)
	private Gmuscular gmusculare;

	//bi-directional many-to-one association to EjerciciosHasLesione
	@OneToMany(mappedBy="ejercicio")
	private List<EjerciciosHasLesion> ejerciciosHasLesiones;

	//bi-directional many-to-one association to ObjetivosHasEjercicio
	@OneToMany(mappedBy="ejercicio")
	private List<EstresEjercicio> objetivosHasEjercicios;

	//bi-directional many-to-one association to RutinasHasEjercicio
	@OneToMany(mappedBy="ejercicio")
	private List<RutinasHasEjercicio> rutinasHasEjercicios;

	public Ejercicio() {
	}

	public int getIdEjercicios() {
		return this.idEjercicios;
	}

	public void setIdEjercicios(int idEjercicios) {
		this.idEjercicios = idEjercicios;
	}

	public int getDificultadTecnica() {
		return this.dificultadTecnica;
	}

	public void setDificultadTecnica(int dificultadTecnica) {
		this.dificultadTecnica = dificultadTecnica;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipoEjercicio() {
		return this.tipoEjercicio;
	}

	public void setTipoEjercicio(int tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}

	public Gmuscular getGmuscular() {
		return this.gmusculare;
	}

	public void setGmusculare(Gmuscular gmusculare) {
		this.gmusculare = gmusculare;
	}

	public List<EjerciciosHasLesion> getEjerciciosHasLesiones() {
		return this.ejerciciosHasLesiones;
	}

	public void setEjerciciosHasLesiones(List<EjerciciosHasLesion> ejerciciosHasLesiones) {
		this.ejerciciosHasLesiones = ejerciciosHasLesiones;
	}

	public EjerciciosHasLesion addEjerciciosHasLesione(EjerciciosHasLesion ejerciciosHasLesione) {
		getEjerciciosHasLesiones().add(ejerciciosHasLesione);
		ejerciciosHasLesione.setEjercicio(this);

		return ejerciciosHasLesione;
	}

	public EjerciciosHasLesion removeEjerciciosHasLesione(EjerciciosHasLesion ejerciciosHasLesione) {
		getEjerciciosHasLesiones().remove(ejerciciosHasLesione);
		ejerciciosHasLesione.setEjercicio(null);

		return ejerciciosHasLesione;
	}

	public List<EstresEjercicio> getObjetivosHasEjercicios() {
		return this.objetivosHasEjercicios;
	}

	public void setObjetivosHasEjercicios(List<EstresEjercicio> objetivosHasEjercicios) {
		this.objetivosHasEjercicios = objetivosHasEjercicios;
	}

	public EstresEjercicio addObjetivosHasEjercicio(EstresEjercicio objetivosHasEjercicio) {
		getObjetivosHasEjercicios().add(objetivosHasEjercicio);
		objetivosHasEjercicio.setEjercicio(this);

		return objetivosHasEjercicio;
	}

	public EstresEjercicio removeObjetivosHasEjercicio(EstresEjercicio objetivosHasEjercicio) {
		getObjetivosHasEjercicios().remove(objetivosHasEjercicio);
		objetivosHasEjercicio.setEjercicio(null);

		return objetivosHasEjercicio;
	}

	public List<RutinasHasEjercicio> getRutinasHasEjercicios() {
		return this.rutinasHasEjercicios;
	}

	public void setRutinasHasEjercicios(List<RutinasHasEjercicio> rutinasHasEjercicios) {
		this.rutinasHasEjercicios = rutinasHasEjercicios;
	}

	public RutinasHasEjercicio addRutinasHasEjercicio(RutinasHasEjercicio rutinasHasEjercicio) {
		getRutinasHasEjercicios().add(rutinasHasEjercicio);
		rutinasHasEjercicio.setEjercicio(this);

		return rutinasHasEjercicio;
	}

	public RutinasHasEjercicio removeRutinasHasEjercicio(RutinasHasEjercicio rutinasHasEjercicio) {
		getRutinasHasEjercicios().remove(rutinasHasEjercicio);
		rutinasHasEjercicio.setEjercicio(null);

		return rutinasHasEjercicio;
	}
}