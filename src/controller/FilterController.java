package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Cliente;
import model.ClientesHasLesion;
import model.DatosObjetivo;
import model.DatosObjetivoPK;
import model.Ejercicio;
import model.Objetivo;
import model.EstresEjercicio;
import model.Rutina;
import model.Rutina.TipoRutina;

class FilterController {
	private HashMap<Ejercicio,Boolean> ejerciciosFiltrados;
	private Cliente cliente;
	private Rutina rutina;
	private static EntityManager em;
	
	public FilterController(Rutina rutina, Cliente cliente) {
		TypedQuery<Ejercicio> query = em.createNamedQuery("Ejercicio.findAll", Ejercicio.class);
		List<Ejercicio> ejercicios = query.getResultList();
		for(Ejercicio e : ejercicios) {
			ejerciciosFiltrados.put(e, true);
		}
		this.cliente = cliente;
		this.rutina = rutina;
	}
	
	public Cliente getCliente(){
	return cliente;
	}
	
	public void setCliente(Cliente cliente){
		this.cliente=cliente;
	}
	
	private void filtradoNivel(){
		int nivel=cliente.getNivelDeportivo();
		Iterator<Ejercicio> it = ejerciciosFiltrados.keySet().iterator();
		while(it.hasNext()){
			Ejercicio ejercicio=it.next();
			if (ejercicio.getNivelEjercicio()>nivel)
				ejerciciosFiltrados.put(ejercicio,false);
		}
	}
	
	private void filtradoLesion() {
		List<ClientesHasLesion> lesiones=cliente.getClientesHasLesiones();
		for(ClientesHasLesion lesion : lesiones) {
			Ejercicio ejercicio = lesion.getEjercicio();
			ejerciciosFiltrados.put(ejercicio, false);
		}
	}
	
	private void filtradoObjetivo(){
		Objetivo objetivo=rutina.getObjetivo();
		Iterator<Ejercicio> it = ejerciciosFiltrados.keySet().iterator();
		while(it.hasNext()){
			Ejercicio ejercicio=it.next();
			List <EstresEjercicio> objetivoEjercicio = ejercicio.getObjetivosHasEjercicios();
			if (!objetivoEjercicio.get(0).equals(objetivo))
				ejerciciosFiltrados.put(ejercicio,false);
		}
	}
	
	private void filtradoSeries() {
		int diasDedicados = cliente.getDiasSemana();
		Iterator<Ejercicio> it = ejerciciosFiltrados.keySet().iterator();
		int idObjetivo = rutina.getObjetivo().getIdObjetivos();
		while(it.hasNext()){
			Ejercicio ejercicio=it.next();
			int tamanoMuscular = ejercicio.getGmuscular().getTamano();
			int tipoEj = ejercicio.getTipoEjercicio();
			int series = em.find(DatosObjetivo.class, new DatosObjetivoPK(idObjetivo, tamanoMuscular, tipoEj)).getNumeroSeries();
			if (series > diasDedicados)
				ejerciciosFiltrados.put(ejercicio,false);
		}
	}
	
	private int determinarTipoTabla(){
		int result = cliente.getMotivacion();
		if (cliente.getMotivacion() == -1){
			Random random = new Random();
			result = random.nextInt() % 2;
		}
		return result;
	}

	public void run(){
		filtradoNivel();
		filtradoLesion();
		filtradoObjetivo();
		filtradoSeries();
		rutina.setEjerciciosFiltrados(ejerciciosFiltrados);
		if (determinarTipoTabla() == 0)
			rutina.setTipoRutina(TipoRutina.tipoCircuito);
		
		else rutina.setTipoRutina(TipoRutina.tipoGrupoMuscular);
		
	}
}
