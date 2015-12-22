package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Cliente;
import model.ClientesHasLesion;
import model.Ejercicio;
import model.Objetivo;
import model.ObjetivosHasEjercicio;
import model.Rutina;

public class FilterController {
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
			List <ObjetivosHasEjercicio> objetivoEjercicio = ejercicio.getObjetivosHasEjercicios();
			if (!objetivoEjercicio.get(0).equals(objetivo))
				ejerciciosFiltrados.put(ejercicio,false);
		}
		//TODO: Mirar el tema de las series.
	}
	

	public void run(){
		filtradoNivel();
		filtradoLesion();
		filtradoObjetivo();
	}
}
