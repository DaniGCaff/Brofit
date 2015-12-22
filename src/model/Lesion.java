package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lesion database table.
 * 
 */
@Entity
@Table(name="lesiones")
@NamedQuery(name="Lesion.findAll", query="SELECT l FROM Lesion l")
public class Lesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idLesiones;

	@Column(length=45)
	private String nombre;

	//bi-directional many-to-one association to ClientesHasLesione
	@OneToMany(mappedBy="lesione")
	private List<ClientesHasLesione> clientesHasLesiones;

	//bi-directional many-to-one association to EjerciciosHasLesione
	@OneToMany(mappedBy="lesione")
	private List<EjerciciosHasLesione> ejerciciosHasLesiones;

	//bi-directional many-to-many association to Gmusculare
	@ManyToMany
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

	public List<ClientesHasLesione> getClientesHasLesiones() {
		return this.clientesHasLesiones;
	}

	public void setClientesHasLesiones(List<ClientesHasLesione> clientesHasLesiones) {
		this.clientesHasLesiones = clientesHasLesiones;
	}

	public ClientesHasLesione addClientesHasLesione(ClientesHasLesione clientesHasLesione) {
		getClientesHasLesiones().add(clientesHasLesione);
		clientesHasLesione.setLesione(this);

		return clientesHasLesione;
	}

	public ClientesHasLesione removeClientesHasLesione(ClientesHasLesione clientesHasLesione) {
		getClientesHasLesiones().remove(clientesHasLesione);
		clientesHasLesione.setLesione(null);

		return clientesHasLesione;
	}

	public List<EjerciciosHasLesione> getEjerciciosHasLesiones() {
		return this.ejerciciosHasLesiones;
	}

	public void setEjerciciosHasLesiones(List<EjerciciosHasLesione> ejerciciosHasLesiones) {
		this.ejerciciosHasLesiones = ejerciciosHasLesiones;
	}

	public EjerciciosHasLesione addEjerciciosHasLesione(EjerciciosHasLesione ejerciciosHasLesione) {
		getEjerciciosHasLesiones().add(ejerciciosHasLesione);
		ejerciciosHasLesione.setLesione(this);

		return ejerciciosHasLesione;
	}

	public EjerciciosHasLesione removeEjerciciosHasLesione(EjerciciosHasLesione ejerciciosHasLesione) {
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