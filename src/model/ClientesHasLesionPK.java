package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the clientes_has_lesiones database table.
 * 
 */
@Embeddable
public class ClientesHasLesionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int clientes_idClientes;

	@Column(unique=true, nullable=false)
	private int lesiones_idLesiones;

	public ClientesHasLesionPK() {
	}
	public int getClientes_idClientes() {
		return this.clientes_idClientes;
	}
	public void setClientes_idClientes(int clientes_idClientes) {
		this.clientes_idClientes = clientes_idClientes;
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
		if (!(other instanceof ClientesHasLesionPK)) {
			return false;
		}
		ClientesHasLesionPK castOther = (ClientesHasLesionPK)other;
		return 
			(this.clientes_idClientes == castOther.clientes_idClientes)
			&& (this.lesiones_idLesiones == castOther.lesiones_idLesiones);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.clientes_idClientes;
		hash = hash * prime + this.lesiones_idLesiones;
		
		return hash;
	}
}