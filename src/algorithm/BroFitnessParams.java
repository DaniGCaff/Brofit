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
	private int frecuenciaCardiacaFinal;
	private int minutosAerobica;
	private float estresAerobico;
	
	public BroFitnessParams(Objetivo objetivo, float estresObjetivo, Configuration conf) throws InvalidConfigurationException {
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
	
	public int getFrecuenciaCardiacaFinal() {
		return frecuenciaCardiacaFinal;
	}

	public void setFrecuenciaCardiacaFinal(int frecuenciaCardiacaFinal) {
		this.frecuenciaCardiacaFinal = frecuenciaCardiacaFinal;
	}

	public float getEstresAerobico() {
		return estresAerobico;
	}

	public void setEstresAerobico(float estresAerobico) {
		this.estresAerobico = estresAerobico;
	}

	public int getMinutosAerobica() {
		return minutosAerobica;
	}

	public void setMinutosAerobica(int minutosAerobica) {
		this.minutosAerobica = minutosAerobica;
	}
	
}
