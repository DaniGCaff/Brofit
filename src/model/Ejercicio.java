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
@NamedQuery(name="Ejercicio.findAll", query="SELECT e FROM Ejercicio e")
public class Ejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idEjercicios;

	private int dificultadTecnica;

	@Column(name="nivel_ejercicio")
	private int nivelEjercicio;

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
	private List<EjerciciosHasLesione> ejerciciosHasLesiones;

	//bi-directional many-to-one association to ObjetivosHasEjercicio
	@OneToMany(mappedBy="ejercicio")
	private List<ObjetivosHasEjercicio> objetivosHasEjercicios;

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

	public int getNivelEjercicio() {
		return this.nivelEjercicio;
	}

	public void setNivelEjercicio(int nivelEjercicio) {
		this.nivelEjercicio = nivelEjercicio;
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

	public Gmuscular getGmusculare() {
		return this.gmusculare;
	}

	public void setGmusculare(Gmuscular gmusculare) {
		this.gmusculare = gmusculare;
	}

	public List<EjerciciosHasLesione> getEjerciciosHasLesiones() {
		return this.ejerciciosHasLesiones;
	}

	public void setEjerciciosHasLesiones(List<EjerciciosHasLesione> ejerciciosHasLesiones) {
		this.ejerciciosHasLesiones = ejerciciosHasLesiones;
	}

	public EjerciciosHasLesione addEjerciciosHasLesione(EjerciciosHasLesione ejerciciosHasLesione) {
		getEjerciciosHasLesiones().add(ejerciciosHasLesione);
		ejerciciosHasLesione.setEjercicio(this);

		return ejerciciosHasLesione;
	}

	public EjerciciosHasLesione removeEjerciciosHasLesione(EjerciciosHasLesione ejerciciosHasLesione) {
		getEjerciciosHasLesiones().remove(ejerciciosHasLesione);
		ejerciciosHasLesione.setEjercicio(null);

		return ejerciciosHasLesione;
	}

	public List<ObjetivosHasEjercicio> getObjetivosHasEjercicios() {
		return this.objetivosHasEjercicios;
	}

	public void setObjetivosHasEjercicios(List<ObjetivosHasEjercicio> objetivosHasEjercicios) {
		this.objetivosHasEjercicios = objetivosHasEjercicios;
	}

	public ObjetivosHasEjercicio addObjetivosHasEjercicio(ObjetivosHasEjercicio objetivosHasEjercicio) {
		getObjetivosHasEjercicios().add(objetivosHasEjercicio);
		objetivosHasEjercicio.setEjercicio(this);

		return objetivosHasEjercicio;
	}

	public ObjetivosHasEjercicio removeObjetivosHasEjercicio(ObjetivosHasEjercicio objetivosHasEjercicio) {
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