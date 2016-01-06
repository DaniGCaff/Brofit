package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rutinas_has_ejercicios database table.
 * 
 */
@Embeddable
public class RutinasHasEjercicioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int rutinas_idRutinas;

	@Column(unique=true, nullable=false)
	private int ejercicios_idEjercicios;

	@Column(name="dia_realizacion", unique=true, nullable=false)
	private int diaRealizacion;

	public RutinasHasEjercicioPK() {
	}
	public int getRutinas_idRutinas() {
		return this.rutinas_idRutinas;
	}
	public void setRutinas_idRutinas(int rutinas_idRutinas) {
		this.rutinas_idRutinas = rutinas_idRutinas;
	}
	public int getEjercicios_idEjercicios() {
		return this.ejercicios_idEjercicios;
	}
	public void setEjercicios_idEjercicios(int ejercicios_idEjercicios) {
		this.ejercicios_idEjercicios = ejercicios_idEjercicios;
	}
	public int getDiaRealizacion() {
		return this.diaRealizacion;
	}
	public void setDiaRealizacion(int diaRealizacion) {
		this.diaRealizacion = diaRealizacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RutinasHasEjercicioPK)) {
			return false;
		}
		RutinasHasEjercicioPK castOther = (RutinasHasEjercicioPK)other;
		return 
			(this.rutinas_idRutinas == castOther.rutinas_idRutinas)
			&& (this.ejercicios_idEjercicios == castOther.ejercicios_idEjercicios)
			&& (this.diaRealizacion == castOther.diaRealizacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.rutinas_idRutinas;
		hash = hash * prime + this.ejercicios_idEjercicios;
		hash = hash * prime + this.diaRealizacion;
		
		return hash;
	}
}