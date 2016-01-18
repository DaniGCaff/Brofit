package model;

import java.io.Serializable;
import javax.persistence.*;

import org.jgap.IChromosome;

import java.util.HashMap;
import java.util.List;


/**
 * The persistent class for the rutinas database table.
 * 
 */
@Entity
@Table(name="rutinas")
@NamedQuery(name="Rutina.findAll", query="SELECT r FROM Rutina r")
public class Rutina implements Serializable {
	
	public enum TipoRutina{
		tipoCircuito,tipoGrupoMuscular;
	}
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idRutinas;
	
	@Transient
	private List<String> musculosDia;
	@Transient
	private HashMap<Ejercicio,Boolean> ejerciciosFiltrados;
	@Transient
	private TipoRutina tipoRutina;
	@Transient
	private IChromosome mejorSolucion;

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
	
	public TipoRutina getTipoRutina(){
		return this.tipoRutina;
	}
	
	public void setTipoRutina(TipoRutina tipoRutina){
		this.tipoRutina = tipoRutina;
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

	public HashMap<Ejercicio,Boolean> getEjerciciosFiltrados() {
		return this.ejerciciosFiltrados;
	}

	public void setEjerciciosFiltrados(HashMap<Ejercicio,Boolean> ejerciciosFiltrados) {
		this.ejerciciosFiltrados = ejerciciosFiltrados;
	}
	
	public Boolean isEjercicioFiltrado(Ejercicio ejercicio) {
		return this.ejerciciosFiltrados.get(ejercicio);
	}
	
	public List<String> getMusculosDia(){
		return this.musculosDia;
	}
	
	public void setMusculosDia(List<String> musculosDia){
		this.musculosDia = musculosDia;
	}
	
	public Objetivo getObjetivo() {
		return this.objetivo;
	}

	public Rutina setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
		return this;
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
	
	public void setMejorSolucion(IChromosome mejorSolucion) {
		this.mejorSolucion = mejorSolucion;
	}
	
	public IChromosome getMejorSolucion() {
		return this.mejorSolucion;
	}
	

}