package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ejercicios_has_lesiones database table.
 * 
 */
@Entity
@Table(name="ejercicios_has_lesiones")
@NamedQuery(name="EjerciciosHasLesion.findAll", query="SELECT e FROM EjerciciosHasLesion e")
public class EjerciciosHasLesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EjerciciosHasLesionPK id;

	private int rehabilitador;

	//bi-directional many-to-one association to Ejercicio
	@ManyToOne
	@JoinColumn(name="Ejercicios_idEjercicios", nullable=false, insertable=false, updatable=false)
	private Ejercicio ejercicio;

	//bi-directional many-to-one association to Lesione
	@ManyToOne
	@JoinColumn(name="Lesiones_idLesiones", nullable=false, insertable=false, updatable=false)
	private Lesion lesione;

	public EjerciciosHasLesion() {
	}

	public EjerciciosHasLesionPK getId() {
		return this.id;
	}

	public void setId(EjerciciosHasLesionPK id) {
		this.id = id;
	}

	public int getRehabilitador() {
		return this.rehabilitador;
	}

	public void setRehabilitador(int rehabilitador) {
		this.rehabilitador = rehabilitador;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Lesion getLesione() {
		return this.lesione;
	}

	public void setLesione(Lesion lesione) {
		this.lesione = lesione;
	}

}