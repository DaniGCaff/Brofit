package controller;

import org.jgap.FitnessFunction;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;

import algorithm.BroFitness;
import algorithm.BroFitnessParams;

class AlgorithmController {

	public static final int MAX_ALLOWED_EVOLUTIONS = 20;
	private BroFitnessParams params;
	
	public AlgorithmController(BroFitnessParams params) {
		this.params = params;
	}
	
	public void run() {
		try {
			FitnessFunction funcionObjetivo = new BroFitness(params);
			params.getConf().setFitnessFunction(funcionObjetivo);
			params.getConf().setSampleChromosome(params.getCromosoma());
			
			Genotype poblacion = Genotype.randomInitialGenotype(params.getConf());
			
			IChromosome mejorSolucion = null;
			int i = 0;
			while(i < MAX_ALLOWED_EVOLUTIONS) {
				poblacion.evolve();
				// TODO: Entiendo que aquí se introducirian las operaciones...
				mejorSolucion = poblacion.getFittestChromosome();
				i++;
			}
			params.setCromosoma(mejorSolucion);
			
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}	
	}

}
