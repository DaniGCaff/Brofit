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
	static final int poblacionMaxima = 5;
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
		int minEjer, maxEjer;
		if(rutina.getTipoRutina() == TipoRutina.tipoGrupoMuscular){
			if ((objetivo.getNombre().equals("Tonificación")) || objetivo.getNombre().equals("Hipertrofia") 
					||(objetivo.getNombre().equals("Pérdida de Peso"))) {
				if (cliente.getDiasSemana() == 5){
					minEjer = 1; maxEjer = 1;
					result.add(new GenG(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenG(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenH(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenG(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenBT(rutina, this.conf, minEjer, maxEjer, em));
				}
				
				else if (cliente.getDiasSemana() == 4){
					minEjer = 1; maxEjer = 2;
					result.add(new GenGH(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenG(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenG(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenBT(rutina, this.conf, minEjer, maxEjer, em));
				}
				
				else if (cliente.getDiasSemana() == 3){
					minEjer = 2; maxEjer = 2;
					result.add(new GenGH(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenGB(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenGT(rutina, this.conf, minEjer, maxEjer, em));
				}
			}
		}
		
		else if (rutina.getTipoRutina() == TipoRutina.tipoCircuito){
			if(objetivo.getNombre().equals("Tonificación") || objetivo.getNombre().equals("Mantenimiento")){
				if (cliente.getDiasSemana() == 5){
					minEjer = 1; maxEjer = 1;
					result.add(new GenTS(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenTI(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenTS(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenTI(rutina, this.conf, minEjer, maxEjer, em));
					result.add(new GenTS(rutina, this.conf, minEjer, maxEjer, em));
				}
			}
		}
		return result;
	}
 
	public void run(){
		// Si es hipert. para 5 días, en un día se hace 1 músculo grande u hombro o 2 especificos (biceps+triceps).
		// Si es hipert. para 4 días, en un día se pueden hacerse <= 2 musculos (1 grande, 1 grande + 1 pequeño, B+T, NO SE PERMITE P+H) Resumen, h+x.
		// Si es hipert. para 3 días, en un día se hacen 2 músculos (1 grande + 1 pequeño, B+T, NO SE PERMITE P+H).
	
		// Si es tonif. para rutina de t.circuito para 5 días:
		//		 - Primer día: tren superior
	    //		 - Segundo día: tren inferior
		//		 - tercer día: tren superior
		// 	     - cuarto día: tren inferior
		// 		 - quinto día: tren superior
		// No se puede hacer un circuito de tonificacion de menos de 5 días?
		
		// Si es tonif para rutina de t.gmuscular para X días:
		//	     - Mismo orden que para hipert. segun los días
		// No se puede hacer tonif en 2 días o menos?
		
		// Si es mtto. se siguen las reglas de tonificación para t.circuito.
		// Si es perdida de peso, se siguen las reglas de hipertrofia.
		
		try {
			RandomGenerator a_numberGenerator = new StockRandomGenerator();
			List<EjercicioGene> results = planificarMusculoDia();
			IBrofitGene[] genes = new IBrofitGene[results.size()*2];
			for(int i = 0; i < results.size(); i++) {
				genes[i] = results.get(i).getDuracionGene();
				genes[i].setToRandomValue(a_numberGenerator);
				genes[i+results.size()] = results.get(i);
				genes[i+results.size()].setToRandomValue(a_numberGenerator);
			}
			
			Chromosome cromosoma = new Chromosome(conf, genes);
			conf.setSampleChromosome(cromosoma);
			conf.setPopulationSize(poblacionMaxima);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
}
