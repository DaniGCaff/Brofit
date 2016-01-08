package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the objetivos_has_ejercicios database table.
 * 
 */
@Entity
@Table(name="DatosObjetivo")
@NamedQuery(name="DatosObjetivo.findAll", query="SELECT d FROM DatosObjetivo d")
public class DatosObjetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DatosObjetivoPK id;

	@Column(name="numeroEjercicios")
	private float numeroEjercicios;
	
	@Column(name="numeroSeries")
	private int numeroSeries;

	public int getNumeroSeries() {
		return numeroSeries;
	}

	public void setNumeroSeries(int numeroSeries) {
		this.numeroSeries = numeroSeries;
	}

	//bi-directional many-to-one association to Objetivo
	@ManyToOne
	@JoinColumn(name="Objetivos_idObjetivos", nullable=false, insertable=false, updatable=false)
	private Objetivo objetivo;
	
	@Column(name="tamanoMuscular", nullable=false, insertable=false, updatable=false)
	private int tamanoMuscular;

	@Column(name="tipoEjercicio", nullable=false, insertable=false, updatable=false)
	private int tipoEjercicio;

	public DatosObjetivo() {
	}

}
