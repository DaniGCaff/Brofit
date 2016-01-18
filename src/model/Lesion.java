package model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the lesion database table.
 * 
 */
@Entity
@Table(name="lesiones")
@NamedQueries({
	@NamedQuery(name="Lesion.findAll", query="SELECT l FROM Lesion l"),
	@NamedQuery(name="Lesion.findByName", query="SELECT l FROM Lesion l WHERE l.nombre = :nombreLesion")	
})
public class Lesion implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idLesiones;

	@Column(name="nombre", length=45)
	private String nombre;
	public enum TipoLesion{
		LEVE,GRAVE;
	}
	//bi-directional many-to-one association to ClientesHasLesione
	@OneToMany(mappedBy="lesion")
	private List<ClientesHasLesion> clientesHasLesiones;

	//bi-directional many-to-one association to EjerciciosHasLesione
	@OneToMany(mappedBy="lesione")
	private List<EjerciciosHasLesion> ejerciciosHasLesiones;

	//bi-directional many-to-many association to Gmusculare
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(
		name="gmusculares_has_lesiones"
		, joinColumns={
			@JoinColumn(name="Lesiones_idLesiones", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="GMusculares_idGMusculares", nullable=false)
			}
		)
	private List<Gmuscular> gmusculares;

	public Lesion() {
	}

	public int getIdLesiones() {
		return this.idLesiones;
	}

	public void setIdLesiones(int idLesiones) {
		this.idLesiones = idLesiones;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ClientesHasLesion> getClientesHasLesiones() {
		return this.clientesHasLesiones;
	}

	public void setClientesHasLesiones(List<ClientesHasLesion> clientesHasLesiones) {
		this.clientesHasLesiones = clientesHasLesiones;
	}

	public ClientesHasLesion addClientesHasLesione(ClientesHasLesion clientesHasLesione) {
		getClientesHasLesiones().add(clientesHasLesione);
		clientesHasLesione.setLesion(this);

		return clientesHasLesione;
	}

	public ClientesHasLesion removeClientesHasLesione(ClientesHasLesion clientesHasLesione) {
		getClientesHasLesiones().remove(clientesHasLesione);
		clientesHasLesione.setLesion(null);

		return clientesHasLesione;
	}

	public List<EjerciciosHasLesion> getEjerciciosHasLesiones() {
		return this.ejerciciosHasLesiones;
	}

	public void setEjerciciosHasLesiones(List<EjerciciosHasLesion> ejerciciosHasLesiones) {
		this.ejerciciosHasLesiones = ejerciciosHasLesiones;
	}

	public EjerciciosHasLesion addEjerciciosHasLesione(EjerciciosHasLesion ejerciciosHasLesione) {
		getEjerciciosHasLesiones().add(ejerciciosHasLesione);
		ejerciciosHasLesione.setLesione(this);

		return ejerciciosHasLesione;
	}

	public EjerciciosHasLesion removeEjerciciosHasLesione(EjerciciosHasLesion ejerciciosHasLesione) {
		getEjerciciosHasLesiones().remove(ejerciciosHasLesione);
		ejerciciosHasLesione.setLesione(null);

		return ejerciciosHasLesione;
	}

	public List<Gmuscular> getGmusculares() {
		return this.gmusculares;
	}

	public void setGmusculares(List<Gmuscular> gmusculares) {
		this.gmusculares = gmusculares;
	}
}