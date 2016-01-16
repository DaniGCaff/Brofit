package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;
import org.jgap.impl.IntegerGene;
import org.jgap.impl.SetGene;
import org.jgap.impl.StockRandomGenerator;

import genes.EjercicioGene;
import genes.GenAbd;
import genes.GenBT;
import genes.GenG;
import genes.GenGB;
import genes.GenGH;
import genes.GenGT;
import genes.GenH;
import genes.GenTI;
import genes.GenTS;
import genes.IBrofitGene;
import model.Cliente;
import model.Objetivo;
import model.Rutina;
import model.Rutina.TipoRutina;

class PlanificacionController extends Controller {
	static final int poblacionMaxima = 10;
	Cliente cliente;
	Rutina rutina;
	Objetivo objetivo;
	Configuration conf;
	
	public PlanificacionController(Cliente cliente, Rutina rutina, Configuration conf, EntityManager em){
		super(em);
		this.cliente = cliente;
		this.rutina = rutina;
		this.objetivo = rutina.getObjetivo();
		this.conf = conf;
	}

	private List<EjercicioGene> planificarMusculoDia() throws InvalidConfigurationException{
		List<EjercicioGene> result = new ArrayList<EjercicioGene>();
		int minEjer = 0, maxEjer = 0;
		if(rutina.getTipoRutina() == TipoRutina.tipoGrupoMuscular){
			if (objetivo.getNombre().equals("Tonificación")) {
				minEjer = 12; maxEjer = 15;
			}
			if (objetivo.getNombre().equals("Hipertrofia")) {
				minEjer = 8; maxEjer = 12;
			}
			if (objetivo.getNombre().equals("Pérdida de Peso")) {
				minEjer = 6; maxEjer = 12;
			}
			
			if (cliente.getDiasSemana() == 5){
				result.add(new GenG(rutina, this.conf, minEjer, maxEjer, em));
				result.add(new GenG(rutina, this.conf, minEjer, maxEjer, em));
				result.add(new GenH(rutina, this.conf, minEjer, maxEjer, em));
				result.add(new GenG(rutina, this.conf, minEjer, maxEjer, em));
				result.add(new GenBT(rutina, this.conf, minEjer, maxEjer, em));
			}
			
			else if (cliente.getDiasSemana() == 4){
				result.add(new GenGH(rutina, this.conf, minEjer, maxEjer, em));
				result.add(new GenG(rutina, this.conf, minEjer, maxEjer, em));
				result.add(new GenG(rutina, this.conf, minEjer, maxEjer, em));
				result.add(new GenBT(rutina, this.conf, minEjer, maxEjer, em));
			}
			
			else if (cliente.getDiasSemana() == 3){
				result.add(new GenGH(rutina, this.conf, minEjer, maxEjer, em));
				result.add(new GenGB(rutina, this.conf, minEjer, maxEjer, em));
				result.add(new GenGT(rutina, this.conf, minEjer, maxEjer, em));
			}
		}
		
		else if (rutina.getTipoRutina() == TipoRutina.tipoCircuito){
			if(objetivo.getNombre().equals("Tonificación")){
				minEjer = 12; maxEjer = 15;
			} else if(objetivo.getNombre().equals("Mantenimiento")) {
				minEjer = 8; maxEjer = 12;
			}
			result.add(new GenTS(rutina, this.conf, minEjer, maxEjer, em));
			result.add(new GenTI(rutina, this.conf, minEjer, maxEjer, em));
			result.add(new GenTS(rutina, this.conf, minEjer, maxEjer, em));
			result.add(new GenTI(rutina, this.conf, minEjer, maxEjer, em));
			result.add(new GenTS(rutina, this.conf, minEjer, maxEjer, em));
		}
		
		int numAbdominales = cliente.getDiasSemana() / 2;
		if(cliente.getDiasSemana() % 2 != 0) {
			numAbdominales ++;
		}
		for(int i = 0; i < numAbdominales; i++) {
			result.add(new GenAbd(rutina, this.conf, 6, 15, em));
		}
		return result;
	}
 
	public void run(){
		try {
			List<EjercicioGene> results = planificarMusculoDia();
			IBrofitGene[] genes = new IBrofitGene[results.size()*2];
			for(int i = 0; i < results.size(); i++) {
				genes[i] = results.get(i).getDuracionGene();
				genes[i].setToRandomValue(conf.getRandomGenerator());
				genes[i+results.size()] = results.get(i);
				genes[i+results.size()].setToRandomValue(conf.getRandomGenerator());
			}
			
			Chromosome cromosoma = new Chromosome(conf, genes);
			conf.setSampleChromosome(cromosoma);
			conf.setPopulationSize(poblacionMaxima);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
}
