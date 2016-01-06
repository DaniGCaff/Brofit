package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the objetivos_has_ejercicios database table.
 * 
 */
@Embeddable
public class EstresEjercicioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int idObjetivos;

	@Column(unique=true, nullable=false)
	private int idEjercicios;
	
	@Column(unique=true, nullable=false)
	private int repeticiones;

	@Column(unique=true, nullable=false)
	private int series;

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public EstresEjercicioPK() {
	}
	
	public EstresEjercicioPK(int ejercicio, int objetivo, int repeticiones, int series) {
		this.idEjercicios = ejercicio;
		this.idObjetivos = objetivo;
		this.repeticiones = repeticiones;
		this.series = series;
	}
	
	public int getidObjetivos() {
		return this.idObjetivos;
	}
	public void setidObjetivos(int idObjetivos) {
		this.idObjetivos = idObjetivos;
	}
	public int getidEjercicios() {
		return this.idEjercicios;
	}
	public void setidEjercicios(int idEjercicios) {
		this.idEjercicios = idEjercicios;
	}
	public int getRepeticiones() {
		return this.repeticiones;
	}
	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EstresEjercicioPK)) {
			return false;
		}
		EstresEjercicioPK castOther = (EstresEjercicioPK)other;
		return 
			(this.idObjetivos == castOther.idObjetivos)
			&& (this.idEjercicios == castOther.idEjercicios)
			&& (this.repeticiones == castOther.repeticiones)
			&& (this.series == castOther.series);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idObjetivos;
		hash = hash * prime + this.idEjercicios;
		hash = hash * prime + this.repeticiones;
		hash = hash * prime + this.series;
		
		return hash;
	}
}