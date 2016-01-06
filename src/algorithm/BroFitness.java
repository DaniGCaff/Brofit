package algorithm;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

import genes.IBrofitGene;

public class BroFitness extends FitnessFunction {

	private static final long serialVersionUID = 1L;
	private BroFitnessParams params;
	
	public BroFitness(BroFitnessParams params) {
		this.params = params;
	}

	@Override
	protected double evaluate(IChromosome cromosoma) {
		IBrofitGene[] genes = (IBrofitGene[]) cromosoma.getGenes();
		float fitness = 0.0f;
		for(IBrofitGene gen : genes) {
			fitness += gen.getEstresAsociado(this.params.getObjetivo());
		}
		return fitness;
	}

}
