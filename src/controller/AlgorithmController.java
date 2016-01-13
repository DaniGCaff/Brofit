package controller;

import javax.persistence.EntityManager;

import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;

import model.Ejercicio;
import algorithm.BroFitness;
import algorithm.BroFitnessParams;

class AlgorithmController extends Controller {

	public static final int MAX_ALLOWED_EVOLUTIONS = 2;
	private BroFitnessParams params;
	
	public AlgorithmController(BroFitnessParams params, EntityManager em) {
		super(em);
		this.params = params;
	}
	
	public void run() {
		try {
			FitnessFunction funcionObjetivo = new BroFitness(params);
			params.getConf().setFitnessFunction(funcionObjetivo);
			//params.getConf().setSampleChromosome(params.);
			
			Genotype poblacion = Genotype.randomInitialGenotype(params.getConf());
			
			IChromosome mejorSolucion = null;
			int i = 0;
			while(i < MAX_ALLOWED_EVOLUTIONS) {
				poblacion.evolve();
				i++;
			}
			mejorSolucion = poblacion.getFittestChromosome();
			params.setCromosoma(mejorSolucion);
			System.out.println("Fitness de la mejor solucion: " + mejorSolucion.getFitnessValue());
			System.out.println("Edad de la solucion: " + mejorSolucion.getAge());
			Gene[] genes = mejorSolucion.getGenes();
			for(int g = 0; g < (mejorSolucion.size()/2); g++) {
				Ejercicio ejercicio = (Ejercicio) em.find(Ejercicio.class, genes[g + (mejorSolucion.size()/2)].getAllele());
				System.out.println(g+1 + " - " + ejercicio.getNombre() + " - " + genes[g].getAllele() + " repeticiones.");
			}
				
			
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}	
	}

}
