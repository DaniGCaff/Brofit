package controller;

import java.util.ArrayList;
import java.util.List;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;

import genes.BrofitGene;
import genes.GenBT;
import genes.GenG;
import genes.GenGB;
import genes.GenGH;
import genes.GenGT;
import genes.GenH;
import genes.GenTI;
import genes.GenTS;
import model.Cliente;
import model.Objetivo;
import model.Rutina;
import model.Rutina.TipoRutina;

class PlanificacionController {
	static final int poblacionMaxima = 500;
	Cliente cliente;
	Rutina rutina;
	Objetivo objetivo;
	Configuration conf;
	
	public PlanificacionController(Cliente cliente, Rutina rutina, Configuration conf){
		this.cliente = cliente;
		this.rutina = rutina;
		this.objetivo = rutina.getObjetivo();
		this.conf = conf;
	}

	private List<BrofitGene> planificarMusculoDia() throws InvalidConfigurationException{
		List <BrofitGene> result = new ArrayList<BrofitGene>();
		int minEjer, maxEjer;
		if(rutina.getTipoRutina() == TipoRutina.tipoGrupoMuscular){
			if ((objetivo.getNombre().equals("perdida_peso")) || objetivo.getNombre().equals("hipertrofia") 
					||(objetivo.getNombre().equals("tonificacion"))) {
				if (cliente.getDiasSemana() == 5){
					minEjer = 1; maxEjer = 1;
					result.add(new GenG(this.conf, minEjer, maxEjer));
					result.add(new GenG(this.conf, minEjer, maxEjer));
					result.add(new GenH(this.conf, minEjer, maxEjer));
					result.add(new GenG(this.conf, minEjer, maxEjer));
					result.add(new GenBT(this.conf, minEjer, maxEjer));
				}
				
				else if (cliente.getDiasSemana() == 4){
					minEjer = 1; maxEjer = 2;
					result.add(new GenGH(this.conf, minEjer, maxEjer));
					result.add(new GenG(this.conf, minEjer, maxEjer));
					result.add(new GenG(this.conf, minEjer, maxEjer));
					result.add(new GenBT(this.conf, minEjer, maxEjer));
				}
				
				else if (cliente.getDiasSemana() == 3){
					minEjer = 2; maxEjer = 2;
					result.add(new GenGH(this.conf, minEjer, maxEjer));
					result.add(new GenGB(this.conf, minEjer, maxEjer));
					result.add(new GenGT(this.conf, minEjer, maxEjer));
				}
			}
		}
		
		else if (rutina.getTipoRutina() == TipoRutina.tipoCircuito){
			if(objetivo.getNombre().equals("tonificacion") || objetivo.getNombre().equals("mantenimiento")){
				if (cliente.getDiasSemana() == 5){
					minEjer = 1; maxEjer = 1;
					result.add(new GenTS(this.conf, minEjer, maxEjer));
					result.add(new GenTI(this.conf, minEjer, maxEjer));
					result.add(new GenTS(this.conf, minEjer, maxEjer));
					result.add(new GenTI(this.conf, minEjer, maxEjer));
					result.add(new GenTS(this.conf, minEjer, maxEjer));
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
			List<BrofitGene> results = planificarMusculoDia();
			Gene[] genes = new BrofitGene[results.size()];
			for(int i = 0; i < results.size(); i++)
				genes[i] = results.get(i);	
			
			Chromosome cromosoma = new Chromosome(conf, genes);
			conf.setSampleChromosome(cromosoma);
			conf.setPopulationSize(poblacionMaxima);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
}
