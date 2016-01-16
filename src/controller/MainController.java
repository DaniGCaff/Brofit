package controller;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;

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
		this.conf = new DefaultConfiguration();
		this.cliente = cliente;
		this.mainRutina = new Rutina().setObjetivo(objetivo);
	}
	
	public MainController run() {
		BroFitnessParams params;
		try {
			params = new BroFitnessParams(mainRutina.getObjetivo(), cliente.getEstresObjetivo(), conf);
			new FilterController(mainRutina, cliente,em).run();
			new PlanificacionController(cliente, mainRutina, conf, em).run();
			new AlgorithmController(params, em).run();
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
