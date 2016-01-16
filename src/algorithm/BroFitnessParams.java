package algorithm;

import org.jgap.Configuration;
import org.jgap.FitnessEvaluator;
import org.jgap.FitnessFunction;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;
import org.jgap.event.EventManager;
import org.jgap.impl.BestChromosomesSelector;
import org.jgap.impl.CrossoverOperator;
import org.jgap.impl.InversionOperator;
import org.jgap.impl.MutationOperator;
import org.jgap.impl.StockRandomGenerator;

import model.Objetivo;

public class BroFitnessParams {

	private Objetivo objetivo;
	private float estresObjetivo;
	private Configuration conf;
	private IChromosome cromosoma;
	
	public BroFitnessParams(Objetivo objetivo, float estresObjetivo, Configuration conf) throws InvalidConfigurationException {
		this.objetivo = objetivo;
		this.estresObjetivo = estresObjetivo;
		this.conf = conf;
		this.cromosoma = conf.getSampleChromosome();
		
	/*	this.conf.addNaturalSelector(new BestChromosomesSelector(this.conf), false);
		RandomGenerator a_numberGenerator = new StockRandomGenerator();
		this.conf.setRandomGenerator(a_numberGenerator);
		this.conf.setEventManager(new EventManager());
		
		this.conf.addGeneticOperator(new CrossoverOperator(this.conf)); // TODO: Determinar indice de crossover
		this.conf.addGeneticOperator(new InversionOperator(this.conf));
		this.conf.addGeneticOperator(new MutationOperator(this.conf)); // TODO: Determinar indice de mutacion */
	}
	
	public Objetivo getObjetivo() {
		return this.objetivo;
	}
	
	public float getEstresObjetivo() {
		return this.estresObjetivo;
	}
	
	public Configuration getConf() {
		return this.conf;
	}
	
	public BroFitnessParams setCromosoma(IChromosome cromosoma) {
		this.cromosoma = cromosoma;
		return this;
	}
	
	public IChromosome getCromosoma() {
		return this.cromosoma;
	}


}
