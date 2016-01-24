package controller;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.DefaultFitnessEvaluator;
import org.jgap.InvalidConfigurationException;
import org.jgap.event.EventManager;
import org.jgap.impl.BestChromosomesSelector;
import org.jgap.impl.ChromosomePool;
import org.jgap.impl.CrossoverOperator;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.GABreeder;
import org.jgap.impl.MutationOperator;
import org.jgap.impl.StockRandomGenerator;

import algorithm.BroFitnessParams;
import model.Cliente;
import model.Objetivo;
import model.Rutina;

public class MainController extends Controller {

	private Configuration conf;
	private Cliente cliente;
	private Rutina mainRutina;
	
	public MainController(Cliente cliente, Objetivo objetivo, EntityManager em) {
		super(em);
		this.conf = new Configuration();
		this.cliente = cliente;
		this.mainRutina = new Rutina().setObjetivo(objetivo);
		this.mainRutina.setCliente(this.cliente);
	}
	
	public MainController run() {
		BroFitnessParams params;
		try {
			conf.setBreeder(new GABreeder());
			conf.setRandomGenerator(new StockRandomGenerator());
			conf.setEventManager(new EventManager());
			BestChromosomesSelector bestChromosomeSelector = new BestChromosomesSelector(conf, 0.90d);
			bestChromosomeSelector.setDoubletteChromosomesAllowed(true);
			conf.addNaturalSelector(bestChromosomeSelector, false);
			conf.setMinimumPopSizePercent(0);
			conf.setSelectFromPrevGen(1.0d);
			conf.setKeepPopulationSizeConstant(true);
			conf.setFitnessEvaluator(new DefaultFitnessEvaluator());
			conf.setChromosomePool(new ChromosomePool());
			conf.addGeneticOperator(new CrossoverOperator(conf, 0.35d));
			conf.addGeneticOperator(new MutationOperator(conf, 12));
			params = new BroFitnessParams(mainRutina.getObjetivo(), cliente.getEstresObjetivo(), conf);
			new PreprocessController(mainRutina, cliente,em).run();
			new PlanificacionController(cliente, mainRutina, conf, em).run();
			new AerobicoController(params, mainRutina, em).run();
			params.setEstresObjetivo(cliente.getEstresObjetivo());
			AlgorithmController algorithmController = new AlgorithmController(params, em);
			algorithmController.run();
			this.mainRutina.setMejorSolucion(params.getCromosoma());
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public Rutina getRutina() {
		return this.mainRutina;
	}

}
