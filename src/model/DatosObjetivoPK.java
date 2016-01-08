package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DatosObjetivoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int tamanoMuscular;
	
	@Column(unique=true, nullable=false)
	private int tipoEjercicio;

	@Column(unique=true, nullable=false)
	private int Objetivos_idObjetivos;

	public DatosObjetivoPK() {
	}
	
	public DatosObjetivoPK(int idObjetivos, int tamanoMuscular, int tipoEjercicio) {
		this.Objetivos_idObjetivos = idObjetivos;
		this.tamanoMuscular = tamanoMuscular;
		this.tipoEjercicio = tipoEjercicio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DatosObjetivoPK)) {
			return false;
		}
		DatosObjetivoPK castOther = (DatosObjetivoPK)other;
		return 
			(this.tamanoMuscular == castOther.tamanoMuscular)
			&& (this.tipoEjercicio == castOther.tipoEjercicio)
			&& (this.Objetivos_idObjetivos == castOther.Objetivos_idObjetivos);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tamanoMuscular;
		hash = hash * prime + this.tipoEjercicio;
		hash = hash * prime + this.Objetivos_idObjetivos;
		
		return hash;
	}
}
