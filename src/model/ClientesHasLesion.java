package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the clientes_has_lesiones database table.
 * 
 */
@Entity
@Table(name="clientes_has_lesiones")
@NamedQuery(name="ClientesHasLesion.findAll", query="SELECT c FROM ClientesHasLesion c")
public class ClientesHasLesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClientesHasLesionPK id;

	public static final int GRAVE = 1;
	public static final int LEVE = 0;
	private int gravedadLesion;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="Clientes_idClientes", nullable=false, insertable=false, updatable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to Lesione
	@ManyToOne
	@JoinColumn(name="Lesiones_idLesiones", nullable=false, insertable=false, updatable=false)
	private Lesion lesione;

	public ClientesHasLesion() {
	}

	public ClientesHasLesionPK getId() {
		return this.id;
	}

	public void setId(ClientesHasLesionPK id) {
		this.id = id;
	}

	public int getGravedadLesion() {
		return this.gravedadLesion;
	}

	public void setGravedadLesion(int gravedadLesion) {
		this.gravedadLesion = gravedadLesion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Lesion getLesione() {
		return this.lesione;
	}

	public void setLesion(Lesion lesione) {
		this.lesione = lesione;
	}
	
	public List<Ejercicio> getEjerciciosNoRehabilitadores(){
		List <EjerciciosHasLesion> ejercicios= getLesione().getEjerciciosHasLesiones();
		List<Ejercicio> result = new ArrayList<Ejercicio>();
		  for(EjerciciosHasLesion ejercicio : ejercicios) {
			  //Todos los de la tabla no son rehabilitadores
				  result.add(ejercicio.getEjercicio());
		  }
		  return result;
		 }

}