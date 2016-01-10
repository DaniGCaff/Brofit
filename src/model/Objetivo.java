package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the objetivos database table.
 * 
 */
@Entity
@Table(name="objetivos")
@NamedQuery(name="Objetivo.findAll", query="SELECT o FROM Objetivo o")
public class Objetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idObjetivos;

	@Column(length=45)
	private String nombre;

	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="objetivo")
	private List<Rutina> rutinas;

	public Objetivo() {
		super();
	}

	public int getIdObjetivos() {
		return this.idObjetivos;
	}

	public void setIdObjetivos(int idObjetivos) {
		this.idObjetivos = idObjetivos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Rutina> getRutinas() {
		return this.rutinas;
	}

	public void setRutinas(List<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	public Rutina addRutina(Rutina rutina) {
		getRutinas().add(rutina);
		rutina.setObjetivo(this);

		return rutina;
	}

	public Rutina removeRutina(Rutina rutina) {
		getRutinas().remove(rutina);
		rutina.setObjetivo(null);

		return rutina;
	}

}