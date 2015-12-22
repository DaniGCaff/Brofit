package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the objetivos_has_ejercicios database table.
 * 
 */
@Entity
@Table(name="objetivos_has_ejercicios")
@NamedQuery(name="ObjetivosHasEjercicio.findAll", query="SELECT o FROM ObjetivosHasEjercicio o")
public class ObjetivosHasEjercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ObjetivosHasEjercicioPK id;

	@Column(name="estres_ejercicio")
	private float estresEjercicio;

	private int repeticiones;

	private int series;

	//bi-directional many-to-one association to Ejercicio
	@ManyToOne
	@JoinColumn(name="Ejercicios_idEjercicios", nullable=false, insertable=false, updatable=false)
	private Ejercicio ejercicio;

	//bi-directional many-to-one association to Objetivo
	@ManyToOne
	@JoinColumn(name="Objetivos_idObjetivos", nullable=false, insertable=false, updatable=false)
	private Objetivo objetivo;

	public ObjetivosHasEjercicio() {
	}

	public ObjetivosHasEjercicioPK getId() {
		return this.id;
	}

	public void setId(ObjetivosHasEjercicioPK id) {
		this.id = id;
	}

	public float getEstresEjercicio() {
		return this.estresEjercicio;
	}

	public void setEstresEjercicio(float estresEjercicio) {
		this.estresEjercicio = estresEjercicio;
	}

	public int getRepeticiones() {
		return this.repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	public int getSeries() {
		return this.series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Objetivo getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

}