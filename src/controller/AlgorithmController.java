package controller;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;

import javax.persistence.EntityManager;

import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;

import algorithm.BroFitness;
import algorithm.BroFitnessParams;
import genes.EjercicioGene;
import model.Ejercicio;
import views.Resultado;

public class AlgorithmController extends Observable {

	public static final int MAX_ALLOWED_EVOLUTIONS = 500;
	private BroFitnessParams params;
	private Resultado resultado;
	private EntityManager em;
	public AlgorithmController(BroFitnessParams params, EntityManager em) {
		resultado = new Resultado();
		this.addObserver(resultado);
		new Thread() {
			public void run() {
				AlgorithmController.this.resultado.run();
			}
		}.start();
		this.em = em;
		this.params = params;
	}
	
	private void imprimirDatosSolucion(IChromosome solucion) {
		
		System.out.println("Fitness de la mejor solucion: " + solucion.getFitnessValue());
		System.out.println("Fitness objetivo: " + params.getEstresObjetivo());
		System.out.println("Edad de la solucion: " + solucion.getAge());
		System.out.println("Ejercicio aerobico (diario): " + params.getFrecuenciaCardiacaFinal() + " pulsaciones a " + params.getMinutosAerobica() + "minutos");
		Gene[] genes = solucion.getGenes();
		for(int g = 0; g < (solucion.size()/2); g++) {
			int diaRutina = ((EjercicioGene)genes[g + (solucion.size()/2)]).getDiaRutina();
			Ejercicio ejercicio = (Ejercicio) em.find(Ejercicio.class, genes[g + (solucion.size()/2)].getAllele());
			System.out.println("Día #" + diaRutina + " - " + genes[g + (solucion.size()/2)].getClass().toGenericString() + " - " + ejercicio.getNombre() + " - " + genes[g].getAllele() + " repeticiones.");
		}
	}
	
	public void run() {
		new Thread() {
			public void run() {
				try {
					
					FitnessFunction funcionObjetivo = new BroFitness(params);
					params.getConf().setFitnessFunction(funcionObjetivo);
					Genotype poblacion = Genotype.randomInitialGenotype(params.getConf());
					IChromosome mejorSolucion = null;
					int i = 0;
					Boolean stop = false;
					while(i <= MAX_ALLOWED_EVOLUTIONS && !stop) {
						System.out.println("Generando generación número " + i + " de cromosomas.");
						IChromosome auxSolucion = poblacion.getFittestChromosome();
						if(mejorSolucion == null) {
						     mejorSolucion = auxSolucion;
						     params.setCromosoma(mejorSolucion);
						    } else {
						     if(auxSolucion.getFitnessValue() <= params.getEstresObjetivo() ||
						       auxSolucion.getFitnessValue() <= mejorSolucion.getFitnessValue()) {
						      mejorSolucion = auxSolucion;
						      params.setCromosoma(mejorSolucion);
						     } else stop = true;
						    }
						AlgorithmController.this.setChanged();
						AlgorithmController.this.notifyObservers(null);
						imprimirDatosSolucion(mejorSolucion);
						poblacion.evolve();
						i++;
					}
				} catch (InvalidConfigurationException e) {
					e.printStackTrace();
				}
			}
		}.start();	
	}

	public BroFitnessParams getParams() {
		return params;
	}

	public EntityManager getEm() {
		return em;
	}
	
}
