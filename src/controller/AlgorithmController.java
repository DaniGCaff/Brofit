package controller;

import javax.persistence.EntityManager;

import org.jgap.FitnessEvaluator;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;
import org.jgap.impl.BestChromosomesSelector;
import org.jgap.impl.StockRandomGenerator;

import model.Ejercicio;
import algorithm.BroEvaluator;
import algorithm.BroFitness;
import algorithm.BroFitnessParams;

class AlgorithmController extends Controller {

	public static final int MAX_ALLOWED_EVOLUTIONS = 200;
	private BroFitnessParams params;
	
	public AlgorithmController(BroFitnessParams params, EntityManager em) {
		super(em);
		this.params = params;
	}
	
	// TODO: @Borja, esto hay que llevarselo a las vistas
	public void imprimirDatosSolucion(IChromosome solucion) {
		System.out.println("Fitness de la mejor solucion: " + solucion.getFitnessValue());
		System.out.println("Fitness objetivo: " + params.getEstresObjetivo());
		System.out.println("Edad de la solucion: " + solucion.getAge());
		Gene[] genes = solucion.getGenes();
		for(int g = 0; g < (solucion.size()/2); g++) {
			Ejercicio ejercicio = (Ejercicio) em.find(Ejercicio.class, genes[g + (solucion.size()/2)].getAllele());
			System.out.println(g+1 + " - " + ejercicio.getNombre() + " - " + genes[g].getAllele() + " repeticiones.");
		}
	}
	
	public void run() {
		try {
			FitnessFunction funcionObjetivo = new BroFitness(params);
			//FitnessEvaluator evaluadorFitness = new BroEvaluator(params.getEstresObjetivo());
			//params.getConf().setFitnessEvaluator(evaluadorFitness);
			params.getConf().setFitnessFunction(funcionObjetivo);
			Genotype poblacion = Genotype.randomInitialGenotype(params.getConf());
			IChromosome mejorSolucion = null;
			int i = 0;
			while(i <= MAX_ALLOWED_EVOLUTIONS) {
				System.out.println("Generando generación número " + i + " de cromosomas.");
				mejorSolucion = poblacion.getFittestChromosome();
				params.setCromosoma(mejorSolucion);
				imprimirDatosSolucion(mejorSolucion);
				poblacion.evolve();
				i++;
			}
			mejorSolucion = poblacion.getFittestChromosome();
			params.setCromosoma(mejorSolucion);
			imprimirDatosSolucion(mejorSolucion);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}	
	}

}
