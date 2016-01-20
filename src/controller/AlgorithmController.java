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
import views.Resultado;
import algorithm.BroFitness;
import algorithm.BroFitnessParams;
import genes.EjercicioGene;

class AlgorithmController extends Controller {

	public static final int MAX_ALLOWED_EVOLUTIONS = 500;
	private BroFitnessParams params;
	private Resultado resultado ;
	public AlgorithmController(BroFitnessParams params, EntityManager em) {
		super(em);
		this.params = params;
		resultado = new Resultado();
	}
	
	// TODO: @Borja, esto hay que llevarselo a las vistas
	public void imprimirDatosSolucion(IChromosome solucion) {
		
		System.out.println("Fitness de la mejor solucion: " + solucion.getFitnessValue());
		System.out.println("Fitness objetivo: " + params.getEstresObjetivo());
		System.out.println("Edad de la solucion: " + solucion.getAge());
		System.out.println("Ejercicio aerobico (diario): " + params.getFrecuenciaCardiacaFinal() + " pulsaciones a " + params.getMinutosAerobica() + "minutos");
		Gene[] genes = solucion.getGenes();
		for(int g = 0; g < (solucion.size()/2); g++) {
			int diaRutina = ((EjercicioGene)genes[g + (solucion.size()/2)]).getDiaRutina();
			Ejercicio ejercicio = (Ejercicio) em.find(Ejercicio.class, genes[g + (solucion.size()/2)].getAllele());
			System.out.println("Día #" + diaRutina + " - " + genes[g + (solucion.size()/2)].getClass().toGenericString() + " - " + ejercicio.getNombre() + " - " + genes[g].getAllele() + " repeticiones.");
		}
	}
	
	public void run() {
		try {
			
			FitnessFunction funcionObjetivo = new BroFitness(params);
			params.getConf().setFitnessFunction(funcionObjetivo);
			Genotype poblacion = Genotype.randomInitialGenotype(params.getConf());
			IChromosome mejorSolucion = null;
			int i = 0;
			Boolean stop = false;
			while(i <= MAX_ALLOWED_EVOLUTIONS && !stop) {
				System.out.println("Generando generación número " + i + " de cromosomas.");
				IChromosome auxSolucion = poblacion.getFittestChromosome();
				if(mejorSolucion == null) {
				     mejorSolucion = auxSolucion;
				     params.setCromosoma(mejorSolucion);
				    } else {
				     if(auxSolucion.getFitnessValue() <= params.getEstresObjetivo() ||
				       auxSolucion.getFitnessValue() <= mejorSolucion.getFitnessValue()) {
				      mejorSolucion = auxSolucion;
				      params.setCromosoma(mejorSolucion);
				     } else stop = true;
				    }
				imprimirDatosSolucion(mejorSolucion);
				poblacion.evolve();
				i++;
			}
			resultado.insertarDatosSolucion(mejorSolucion, params, em);
			mejorSolucion = poblacion.getFittestChromosome();
			params.setCromosoma(mejorSolucion);
			imprimirDatosSolucion(mejorSolucion);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}	
	}

}
