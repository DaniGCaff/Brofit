package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ejercicios_has_lesiones database table.
 * 
 */
@Embeddable
public class EjerciciosHasLesionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int ejercicios_idEjercicios;

	@Column(unique=true, nullable=false)
	private int lesiones_idLesiones;

	public EjerciciosHasLesionPK() {
	}
	
	public EjerciciosHasLesionPK(int ejercicioId, int lesionesId) {
		this.ejercicios_idEjercicios = ejercicioId;
		this.lesiones_idLesiones = lesionesId;
	}
	
	public int getEjercicios_idEjercicios() {
		return this.ejercicios_idEjercicios;
	}
	public void setEjercicios_idEjercicios(int ejercicios_idEjercicios) {
		this.ejercicios_idEjercicios = ejercicios_idEjercicios;
	}
	public int getLesiones_idLesiones() {
		return this.lesiones_idLesiones;
	}
	public void setLesiones_idLesiones(int lesiones_idLesiones) {
		this.lesiones_idLesiones = lesiones_idLesiones;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EjerciciosHasLesionPK)) {
			return false;
		}
		EjerciciosHasLesionPK castOther = (EjerciciosHasLesionPK)other;
		return 
			(this.ejercicios_idEjercicios == castOther.ejercicios_idEjercicios)
			&& (this.lesiones_idLesiones == castOther.lesiones_idLesiones);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ejercicios_idEjercicios;
		hash = hash * prime + this.lesiones_idLesiones;
		
		return hash;
	}
}