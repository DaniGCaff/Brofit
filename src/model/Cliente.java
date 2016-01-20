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
	public static final int superior = 0;
	public static final int inferior = 1;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idCliente;

	private float aerobica;

	private float altura;

	private float anaerobicaA;

	private float anaerobicaI;

	private float anaerobicaS;

	private float coeficienteProgreso;
	@Transient
	private float coeficienteRegresionS = 1.00f;
	@Transient
	private float coeficienteRegresionI = 1.00f;

	@Column(name="dias_semana")
	private int diasSemana;

	private int edad;

	private int fr;

	private int motivacion;

	private int nivelDeportivo;

	private float peso;

	//bi-directional many-to-one association to ClientesHasLesione
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<ClientesHasLesion> clientesHasLesiones;

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

	public List<ClientesHasLesion> getClientesHasLesiones() {
		return this.clientesHasLesiones;
	}

	public void setClientesHasLesiones(List<ClientesHasLesion> clientesHasLesiones) {
		this.clientesHasLesiones = clientesHasLesiones;
	}

	public ClientesHasLesion addClientesHasLesione(ClientesHasLesion clientesHasLesione) {
		getClientesHasLesiones().add(clientesHasLesione);
		clientesHasLesione.setCliente(this);

		return clientesHasLesione;
	}

	public ClientesHasLesion removeClientesHasLesione(ClientesHasLesion clientesHasLesione) {
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
	
	public float getEstresObjetivo() {	
		int imc = Estres.calcularIMC(peso, altura);
		float estres_an_inf=Estres.getEstresAnInf((int)this.anaerobicaI);
		float estres_an_sup=Estres.getEstresAnSup((int)this.anaerobicaS);
		float estres_an_ab=Estres.getEstresAnAb((int)this.anaerobicaA);
		float estres_ae=Estres.getEstresAerobico(imc, (int)aerobica);
		float co_progreso = Estres.getCoProgreso(imc,(int)aerobica);
		
		float coeficienteDias = 1.0f;
		if(diasSemana == 3) coeficienteDias = 0.9f;
		else if(diasSemana == 4) coeficienteDias = 0.875f;
		else if(diasSemana == 5) coeficienteDias = 0.85f;
		
		return  ((estres_an_inf*coeficienteRegresionI+estres_an_sup*coeficienteRegresionS+estres_an_ab+estres_ae)*co_progreso)*coeficienteDias;	
	}

	public float getCoRegresionS() {		
		return coeficienteRegresionS;
	}
	
	public float getCoRegresionI() {		
		return coeficienteRegresionI;
	}
	
	public void setCoRegresionS(float coeficienteRegresionS){
		this.coeficienteRegresionS=coeficienteRegresionS;
	}
	
	public void setCoRegresionI(float coeficienteRegresionI){
		this.coeficienteRegresionI=coeficienteRegresionI;
	}
	

}