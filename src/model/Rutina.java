package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rutinas database table.
 * 
 */
@Entity
@Table(name="rutinas")
@NamedQuery(name="Rutina.findAll", query="SELECT r FROM Rutina r")
public class Rutina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idRutinas;

	@Column(name="estres_resultante")
	private float estresResultante;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="Clientes_idCliente", nullable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to Objetivo
	@ManyToOne
	@JoinColumn(name="Objetivos_idObjetivos", nullable=false)
	private Objetivo objetivo;

	//bi-directional many-to-one association to RutinasHasEjercicio
	@OneToMany(mappedBy="rutina")
	private List<RutinasHasEjercicio> rutinasHasEjercicios;

	public Rutina() {
	}

	public int getIdRutinas() {
		return this.idRutinas;
	}

	public void setIdRutinas(int idRutinas) {
		this.idRutinas = idRutinas;
	}

	public float getEstresResultante() {
		return this.estresResultante;
	}

	public void setEstresResultante(float estresResultante) {
		this.estresResultante = estresResultante;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Objetivo getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public List<RutinasHasEjercicio> getRutinasHasEjercicios() {
		return this.rutinasHasEjercicios;
	}

	public void setRutinasHasEjercicios(List<RutinasHasEjercicio> rutinasHasEjercicios) {
		this.rutinasHasEjercicios = rutinasHasEjercicios;
	}

	public RutinasHasEjercicio addRutinasHasEjercicio(RutinasHasEjercicio rutinasHasEjercicio) {
		getRutinasHasEjercicios().add(rutinasHasEjercicio);
		rutinasHasEjercicio.setRutina(this);

		return rutinasHasEjercicio;
	}

	public RutinasHasEjercicio removeRutinasHasEjercicio(RutinasHasEjercicio rutinasHasEjercicio) {
		getRutinasHasEjercicios().remove(rutinasHasEjercicio);
		rutinasHasEjercicio.setRutina(null);

		return rutinasHasEjercicio;
	}

}