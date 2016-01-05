package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the objetivos_has_ejercicios database table.
 * 
 */
@Embeddable
public class ObjetivosHasEjercicioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int objetivos_idObjetivos;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int ejercicios_idEjercicios;

	public ObjetivosHasEjercicioPK() {
	}
	
	public ObjetivosHasEjercicioPK(int ejercicio, int objetivo) {
		this.ejercicios_idEjercicios = ejercicio;
		this.objetivos_idObjetivos = objetivo;
	}
	
	public int getObjetivos_idObjetivos() {
		return this.objetivos_idObjetivos;
	}
	public void setObjetivos_idObjetivos(int objetivos_idObjetivos) {
		this.objetivos_idObjetivos = objetivos_idObjetivos;
	}
	public int getEjercicios_idEjercicios() {
		return this.ejercicios_idEjercicios;
	}
	public void setEjercicios_idEjercicios(int ejercicios_idEjercicios) {
		this.ejercicios_idEjercicios = ejercicios_idEjercicios;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ObjetivosHasEjercicioPK)) {
			return false;
		}
		ObjetivosHasEjercicioPK castOther = (ObjetivosHasEjercicioPK)other;
		return 
			(this.objetivos_idObjetivos == castOther.objetivos_idObjetivos)
			&& (this.ejercicios_idEjercicios == castOther.ejercicios_idEjercicios);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.objetivos_idObjetivos;
		hash = hash * prime + this.ejercicios_idEjercicios;
		
		return hash;
	}
}