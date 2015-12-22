package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rutinas_has_ejercicios database table.
 * 
 */
@Entity
@Table(name="rutinas_has_ejercicios")
@NamedQuery(name="RutinasHasEjercicio.findAll", query="SELECT r FROM RutinasHasEjercicio r")
public class RutinasHasEjercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RutinasHasEjercicioPK id;

	//bi-directional many-to-one association to Ejercicio
	@ManyToOne
	@JoinColumn(name="Ejercicios_idEjercicios", nullable=false, insertable=false, updatable=false)
	private Ejercicio ejercicio;

	//bi-directional many-to-one association to Rutina
	@ManyToOne
	@JoinColumn(name="Rutinas_idRutinas", nullable=false, insertable=false, updatable=false)
	private Rutina rutina;

	public RutinasHasEjercicio() {
	}

	public RutinasHasEjercicioPK getId() {
		return this.id;
	}

	public void setId(RutinasHasEjercicioPK id) {
		this.id = id;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Rutina getRutina() {
		return this.rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

}