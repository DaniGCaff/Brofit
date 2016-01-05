package algorithm;

import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;

import model.Ejercicio;
import model.Objetivo;

public class BroFitness extends FitnessFunction {

	private BroFitnessParams params;
	
	public BroFitness(BroFitnessParams params) {
		this.params = params;
	}

	@Override
	protected double evaluate(IChromosome cromosoma) {
		// TODO Auto-generated method stub
		Gene[] genes = cromosoma.getGenes();
		float fitness = 0.0f;
		for(Gene gen : genes) {
			fitness += Ejercicio.findById((Integer) gen.getAllele()).getEstres(params.getObjetivo());
		}
		return 1/fitness;
	}

}
