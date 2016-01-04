package controller;

import org.jgap.Configuration;
import org.jgap.impl.DefaultConfiguration;

import algorithm.BroFitnessParams;
import model.Cliente;
import model.Objetivo;
import model.Rutina;

public class MainController {

	private Configuration conf;
	private Cliente cliente;
	private Rutina mainRutina;
	
	public MainController(Cliente cliente, Objetivo objetivo) {
		this.conf = new DefaultConfiguration();
		this.cliente = cliente;
		this.mainRutina = new Rutina().setObjetivo(objetivo);
	}
	
	public MainController run() {
		BroFitnessParams params = new BroFitnessParams(mainRutina.getObjetivo(), cliente.getEstresObjetivo(), conf);
		
		new FilterController(mainRutina, cliente).run();
		new PlanificacionController(cliente, mainRutina, conf).run();
		new AlgorithmController(params).run();
		
		this.mainRutina.setMejorSolucion(params.getCromosoma());
		return this;
	}
	
	public Rutina getRutina() {
		return this.mainRutina;
	}

}
