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

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BroFit");
	private static EntityManager em = emf.createEntityManager();
	@Id
	@Column(unique=true, nullable=false)
	private int idObjetivos;

	@Column(length=45)
	private String nombre;

	private int num_ejercicio_Aerobica;

	private int num_ejerciciosF_G;

	private int num_ejerciciosF_M;

	private int num_ejerciciosF_MG;

	private int num_ejerciciosF_N;

	private int num_ejerciciosF_P;

	private int num_ejerciciosT_M;

	private int num_ejerciciosT_MG;

	private int num_ejerciciosT_P;

	private int num_series_G;

	private int num_series_M;

	private int num_series_MG;

	private int num_series_N;

	private int num_series_P;

	//bi-directional many-to-one association to ObjetivosHasEjercicio
	@OneToMany(mappedBy="objetivo")
	private List<ObjetivosHasEjercicio> objetivosHasEjercicios;

	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="objetivo")
	private List<Rutina> rutinas;

	public Objetivo() {
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

	public int getNum_ejercicio_Aerobica() {
		return this.num_ejercicio_Aerobica;
	}

	public void setNum_ejercicio_Aerobica(int num_ejercicio_Aerobica) {
		this.num_ejercicio_Aerobica = num_ejercicio_Aerobica;
	}

	public int getNum_ejerciciosF_G() {
		return this.num_ejerciciosF_G;
	}

	public void setNum_ejerciciosF_G(int num_ejerciciosF_G) {
		this.num_ejerciciosF_G = num_ejerciciosF_G;
	}

	public int getNum_ejerciciosF_M() {
		return this.num_ejerciciosF_M;
	}

	public void setNum_ejerciciosF_M(int num_ejerciciosF_M) {
		this.num_ejerciciosF_M = num_ejerciciosF_M;
	}

	public int getNum_ejerciciosF_MG() {
		return this.num_ejerciciosF_MG;
	}

	public void setNum_ejerciciosF_MG(int num_ejerciciosF_MG) {
		this.num_ejerciciosF_MG = num_ejerciciosF_MG;
	}

	public int getNum_ejerciciosF_N() {
		return this.num_ejerciciosF_N;
	}

	public void setNum_ejerciciosF_N(int num_ejerciciosF_N) {
		this.num_ejerciciosF_N = num_ejerciciosF_N;
	}

	public int getNum_ejerciciosF_P() {
		return this.num_ejerciciosF_P;
	}

	public void setNum_ejerciciosF_P(int num_ejerciciosF_P) {
		this.num_ejerciciosF_P = num_ejerciciosF_P;
	}

	public int getNum_ejerciciosT_M() {
		return this.num_ejerciciosT_M;
	}

	public void setNum_ejerciciosT_M(int num_ejerciciosT_M) {
		this.num_ejerciciosT_M = num_ejerciciosT_M;
	}

	public int getNum_ejerciciosT_MG() {
		return this.num_ejerciciosT_MG;
	}

	public void setNum_ejerciciosT_MG(int num_ejerciciosT_MG) {
		this.num_ejerciciosT_MG = num_ejerciciosT_MG;
	}

	public int getNum_ejerciciosT_P() {
		return this.num_ejerciciosT_P;
	}

	public void setNum_ejerciciosT_P(int num_ejerciciosT_P) {
		this.num_ejerciciosT_P = num_ejerciciosT_P;
	}

	public int getNum_series_G() {
		return this.num_series_G;
	}

	public void setNum_series_G(int num_series_G) {
		this.num_series_G = num_series_G;
	}

	public int getNum_series_M() {
		return this.num_series_M;
	}

	public void setNum_series_M(int num_series_M) {
		this.num_series_M = num_series_M;
	}

	public int getNum_series_MG() {
		return this.num_series_MG;
	}

	public void setNum_series_MG(int num_series_MG) {
		this.num_series_MG = num_series_MG;
	}

	public int getNum_series_N() {
		return this.num_series_N;
	}

	public void setNum_series_N(int num_series_N) {
		this.num_series_N = num_series_N;
	}

	public int getNum_series_P() {
		return this.num_series_P;
	}

	public void setNum_series_P(int num_series_P) {
		this.num_series_P = num_series_P;
	}

	public List<ObjetivosHasEjercicio> getObjetivosHasEjercicios() {
		return this.objetivosHasEjercicios;
	}

	public void setObjetivosHasEjercicios(List<ObjetivosHasEjercicio> objetivosHasEjercicios) {
		this.objetivosHasEjercicios = objetivosHasEjercicios;
	}

	public ObjetivosHasEjercicio addObjetivosHasEjercicio(ObjetivosHasEjercicio objetivosHasEjercicio) {
		getObjetivosHasEjercicios().add(objetivosHasEjercicio);
		objetivosHasEjercicio.setObjetivo(this);

		return objetivosHasEjercicio;
	}

	public ObjetivosHasEjercicio removeObjetivosHasEjercicio(ObjetivosHasEjercicio objetivosHasEjercicio) {
		getObjetivosHasEjercicios().remove(objetivosHasEjercicio);
		objetivosHasEjercicio.setObjetivo(null);

		return objetivosHasEjercicio;
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
	
	public static  Objetivo findObjetive(int id){
		
		return em.find(Objetivo.class, id);
	}

}