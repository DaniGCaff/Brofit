package controller;

import javax.persistence.EntityManager;

import org.jgap.FitnessFunction;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;

import algorithm.BroFitness;
import algorithm.BroFitnessParams;

class AlgorithmController extends Controller {

	public static final int MAX_ALLOWED_EVOLUTIONS = 20;
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
				// TODO: Entiendo que aquí se introducirian las operaciones de crossover y mutacion...
				mejorSolucion = poblacion.getFittestChromosome();
				i++;
			}
			params.setCromosoma(mejorSolucion);
			
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}	
	}

}
