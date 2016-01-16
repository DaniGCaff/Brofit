package algorithm;

import org.jgap.FitnessEvaluator;
import org.jgap.IChromosome;

public class BroEvaluator implements FitnessEvaluator {

	float estresObjetivo;
	
	public BroEvaluator(float estresObjetivo) {
		this.estresObjetivo = estresObjetivo;
	}
	
	@Override
	public boolean isFitter(double a_fitness_value1, double a_fitness_value2) {
		if(a_fitness_value1 > estresObjetivo) return false;
		else if(a_fitness_value1 > a_fitness_value2) return true;
		return false;
	}

	@Override
	public boolean isFitter(IChromosome a_chrom1, IChromosome a_chrom2) {
		return isFitter(a_chrom1.getFitnessValue(), a_chrom2.getFitnessValue());
	}

}
