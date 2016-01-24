package controller;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.persistence.EntityManager;
import javax.swing.JPanel;

import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;

import algorithm.BroFitness;
import algorithm.BroFitnessParams;
import genes.EjercicioGene;
import model.Ejercicio;
import views.Grafica;
import views.Resultado;

import java.awt.Graphics;

public class AlgorithmController extends Observable {

	public static final int MAX_ALLOWED_EVOLUTIONS = 300;
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
					int[] mediasEvolucion = new int[MAX_ALLOWED_EVOLUTIONS];
					int[] numeroEvolucion = new int[MAX_ALLOWED_EVOLUTIONS];
					//JPanel panelGrafico=new JPanel();
					//Graphics grafico = panelGrafico.getGraphics();
					while(i < MAX_ALLOWED_EVOLUTIONS && !stop) {
						
						List <IChromosome> mediaSolucion = poblacion.getFittestChromosomes(PlanificacionController.poblacionMaxima);
						//EL medio y el que mas se acerqe a l media fitness value. valor absoluto de la media
							double media=0;
							for (IChromosome ch : mediaSolucion){
								media=media+ch.getFitnessValue();
							}
							media=media/PlanificacionController.poblacionMaxima;
							mediasEvolucion[i]=(int)media;
							
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
					for(int j=0;j<MAX_ALLOWED_EVOLUTIONS;j++){
						numeroEvolucion[j]=j+1;
					}
					
					//grafico.drawPolyline(numeroEvolucion, mediasEvolucion, MAX_ALLOWED_EVOLUTIONS);
					new Grafica(numeroEvolucion, mediasEvolucion, MAX_ALLOWED_EVOLUTIONS);
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
