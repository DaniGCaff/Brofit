package algorithm;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.IChromosome;

import model.Objetivo;

public class BroFitnessParams {

	private Objetivo objetivo;
	private float estresObjetivo;
	private Configuration conf;
	private IChromosome cromosoma;
	
	public BroFitnessParams(Objetivo objetivo, float estresObjetivo, Configuration conf) {
		this.objetivo = objetivo;
		this.estresObjetivo = estresObjetivo;
		this.conf = conf;
		this.cromosoma = conf.getSampleChromosome();
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
