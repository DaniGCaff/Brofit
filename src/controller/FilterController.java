package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Lesion;
import model.Cliente;
import model.ClientesHasLesion;
import model.DatosObjetivo;
import model.DatosObjetivoPK;
import model.Ejercicio;
import model.EjerciciosHasLesion;
import model.Objetivo;
import model.EstresEjercicio;
import model.Gmuscular;
import model.Lesion.TipoLesion;
import model.Rutina;
import model.Rutina.TipoRutina;
import model.TrenCorporal;

class FilterController extends Controller {
	private HashMap<Ejercicio,Boolean> ejerciciosFiltrados;
	private Cliente cliente;
	private Rutina rutina;
	
	public FilterController(Rutina rutina, Cliente cliente,EntityManager em ) {
		
		super(em);	
		ejerciciosFiltrados = new HashMap<Ejercicio,Boolean>();
		List<Ejercicio> ejercicios = em.createNamedQuery("Ejercicio.findAll").getResultList();
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
			if (ejercicio.getDificultadTecnica()>nivel)
				ejerciciosFiltrados.put(ejercicio,false);
		}
	}
	
	private void filtradoLesion() {
		List<ClientesHasLesion> lesiones=cliente.getClientesHasLesiones();
		for(ClientesHasLesion lesionCliente : lesiones) {
			//Lesion leve
			em.refresh(lesionCliente);
			Lesion lesion = (Lesion)em.find(Lesion.class, lesionCliente.getLesione().getIdLesiones());
			if (lesionCliente.getGravedadLesion()==TipoLesion.LEVE.ordinal()){
				em.merge(lesion);
				List<Gmuscular> gmuscular = lesion.getGmusculares();
				List<Ejercicio> ejercicios = lesionCliente.getEjerciciosNoRehabilitadores();
				for(Ejercicio ejer : ejercicios){
					for (Gmuscular gm : gmuscular){
						if(ejer.getGmuscular()==gm)
							ejerciciosFiltrados.put(ejer, false);
						//Superior
						if(gm.getTipoTren()==TrenCorporal.SUPERIOR.valor){
							cliente.setCoRegresionS(0.75f);
						}
						//Inferior
						else if(gm.getTipoTren()==TrenCorporal.INFERIOR.valor){
							cliente.setCoRegresionI(0.75f);
						}
					}
				}	
			}
			//Lesion grave
			else{
				List<Gmuscular> gmuscular = lesion.getGmusculares();
				List<Ejercicio> ejercicios=new ArrayList<Ejercicio>();
				for(Gmuscular gm : gmuscular){
					ejercicios =(List<Ejercicio>)em.createNamedQuery("Ejercicio.findByTren")
											.setParameter("tren", gm.getTipoTren()).getResultList();
					
					for (Ejercicio ejer : ejercicios){
						
						ejerciciosFiltrados.put(ejer, false);
						//Superior
						if(gm.getTipoTren()==TrenCorporal.SUPERIOR.valor){
							cliente.setCoRegresionS(0.00f);
						}
						//Inferior
						else if(gm.getTipoTren()==TrenCorporal.INFERIOR.valor){
							cliente.setCoRegresionI(0.00f);
						}
					}
				}
			}
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
		//TODO: VER COMO HACEMOS ESTE FILTRADO
		//filtradoObjetivo();
		rutina.setEjerciciosFiltrados(ejerciciosFiltrados);
		if (determinarTipoTabla() == 0)
			rutina.setTipoRutina(TipoRutina.tipoCircuito);
		
		else rutina.setTipoRutina(TipoRutina.tipoGrupoMuscular);
		
	}
}
