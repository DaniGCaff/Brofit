package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idCliente;

	private float aerobica;

	private float altura;

	private float anaerobicaA;

	private float anaerobicaI;

	private float anaerobicaS;

	private float coeficienteProgreso;

	@Column(name="dias_semana")
	private int diasSemana;

	private int edad;

	private int fr;

	private int motivacion;

	private int nivelDeportivo;

	private float peso;

	//bi-directional many-to-one association to ClientesHasLesione
	@OneToMany(mappedBy="cliente")
	private List<ClientesHasLesione> clientesHasLesiones;

	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="cliente")
	private List<Rutina> rutinas;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public float getAerobica() {
		return this.aerobica;
	}

	public void setAerobica(float aerobica) {
		this.aerobica = aerobica;
	}

	public float getAltura() {
		return this.altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getAnaerobicaA() {
		return this.anaerobicaA;
	}

	public void setAnaerobicaA(float anaerobicaA) {
		this.anaerobicaA = anaerobicaA;
	}

	public float getAnaerobicaI() {
		return this.anaerobicaI;
	}

	public void setAnaerobicaI(float anaerobicaI) {
		this.anaerobicaI = anaerobicaI;
	}

	public float getAnaerobicaS() {
		return this.anaerobicaS;
	}

	public void setAnaerobicaS(float anaerobicaS) {
		this.anaerobicaS = anaerobicaS;
	}

	public float getCoeficienteProgreso() {
		return this.coeficienteProgreso;
	}

	public void setCoeficienteProgreso(float coeficienteProgreso) {
		this.coeficienteProgreso = coeficienteProgreso;
	}

	public int getDiasSemana() {
		return this.diasSemana;
	}

	public void setDiasSemana(int diasSemana) {
		this.diasSemana = diasSemana;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getFr() {
		return this.fr;
	}

	public void setFr(int fr) {
		this.fr = fr;
	}

	public int getMotivacion() {
		return this.motivacion;
	}

	public void setMotivacion(int motivacion) {
		this.motivacion = motivacion;
	}

	public int getNivelDeportivo() {
		return this.nivelDeportivo;
	}

	public void setNivelDeportivo(int nivelDeportivo) {
		this.nivelDeportivo = nivelDeportivo;
	}

	public float getPeso() {
		return this.peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public List<ClientesHasLesione> getClientesHasLesiones() {
		return this.clientesHasLesiones;
	}

	public void setClientesHasLesiones(List<ClientesHasLesione> clientesHasLesiones) {
		this.clientesHasLesiones = clientesHasLesiones;
	}

	public ClientesHasLesione addClientesHasLesione(ClientesHasLesione clientesHasLesione) {
		getClientesHasLesiones().add(clientesHasLesione);
		clientesHasLesione.setCliente(this);

		return clientesHasLesione;
	}

	public ClientesHasLesione removeClientesHasLesione(ClientesHasLesione clientesHasLesione) {
		getClientesHasLesiones().remove(clientesHasLesione);
		clientesHasLesione.setCliente(null);

		return clientesHasLesione;
	}

	public List<Rutina> getRutinas() {
		return this.rutinas;
	}

	public void setRutinas(List<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	public Rutina addRutina(Rutina rutina) {
		getRutinas().add(rutina);
		rutina.setCliente(this);

		return rutina;
	}

	public Rutina removeRutina(Rutina rutina) {
		getRutinas().remove(rutina);
		rutina.setCliente(null);

		return rutina;
	}

}