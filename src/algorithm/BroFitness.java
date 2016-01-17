package algorithm;

import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;

import genes.RepeticionesGene;
import genes.EjercicioGene;
import genes.IBrofitGene;

public class BroFitness extends FitnessFunction {

	private static final long serialVersionUID = 1L;
	private BroFitnessParams params;
	
	public BroFitness(BroFitnessParams params) {
		this.params = params;
	}

	@Override
	protected double evaluate(IChromosome cromosoma) {
		Gene[] genes = (Gene[]) cromosoma.getGenes();
		float fitness = params.getEstresAerobico();
		for(int i = genes.length/2; i < genes.length; i++) {
			fitness += ((IBrofitGene) genes[i]).getEstresAsociado(this.params.getObjetivo(), (RepeticionesGene) genes[i - genes.length/2]);
		}
		return fitness;
	}

}
