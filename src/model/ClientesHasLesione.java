package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clientes_has_lesiones database table.
 * 
 */
@Entity
@Table(name="clientes_has_lesiones")
@NamedQuery(name="ClientesHasLesione.findAll", query="SELECT c FROM ClientesHasLesione c")
public class ClientesHasLesione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClientesHasLesionePK id;

	private int gravedadLesion;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="Clientes_idClientes", nullable=false, insertable=false, updatable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to Lesione
	@ManyToOne
	@JoinColumn(name="Lesiones_idLesiones", nullable=false, insertable=false, updatable=false)
	private Lesion lesione;

	public ClientesHasLesione() {
	}

	public ClientesHasLesionePK getId() {
		return this.id;
	}

	public void setId(ClientesHasLesionePK id) {
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

	public void setLesione(Lesion lesione) {
		this.lesione = lesione;
	}

}