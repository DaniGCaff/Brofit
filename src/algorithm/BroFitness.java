package algorithm;

import org.jgap.FitnessFunction;
import org.jgap.Gene;
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
		Gene[] genes = (Gene[]) cromosoma.getGenes();
		float fitness = 0.0f;
		for(Gene gen : genes) {
			if(gen.getClass().isInstance(IBrofitGene.class))
				fitness += ((IBrofitGene) gen).getEstresAsociado(this.params.getObjetivo());
		}
		return fitness;
	}

}
