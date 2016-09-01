package controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;

import genes.EjercicioGene;
import genes.GenAbd;
import genes.GenGDorsal;
import genes.GenGPectoral;
import genes.GenMGPierna;
import genes.GenMHombro;
import genes.GenPBiceps;
import genes.GenPTriceps;
import genes.IBrofitGene;
import model.Cliente;
import model.ClientesHasLesion;
import model.DatosObjetivo;
import model.DatosObjetivoPK;
import model.Objetivo;
import model.Rutina;
import model.Rutina.TipoRutina;
import model.TamanoGMuscular;

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
		int minRep = 0, maxRep = 0, numEjercicio;
		int dia = 1;
		DatosObjetivoPK pk;
		DatosObjetivoPK pk2;
		/* 
		 * Pectoral +
		 * Dorsal +
		 * Hombro +
		 * Biceps +
		 * Triceps +
		 * Pierna+
		 * Abdomen +
		 */
		if(rutina.getTipoRutina() == TipoRutina.tipoGrupoMuscular){
			if (objetivo.getNombre().equals("Tonificación")) {
				minRep = 12; maxRep = 15;
			}
			if (objetivo.getNombre().equals("Hipertrofia")) {
				minRep = 6; maxRep = 10;
			}
			//PARA CADA UNO METER LOS DE TECNICCA Y COPIAR EL IF A DODE MANTENIMIENTO
			if (cliente.getDiasSemana() == 5){
				dia = 1;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
				}
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
				}

				dia = 2;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGDorsal(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGDorsal(rutina, this.conf, minRep, maxRep, em, dia));
				}

				dia = 3;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MUY_GRANDE.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMGPierna(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MUY_GRANDE.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMGPierna(rutina, this.conf, minRep, maxRep, em, dia));
				}

				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				dia = 4;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPBiceps(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPBiceps(rutina, this.conf, minRep, maxRep, em, dia));
				}

				
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPTriceps(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPTriceps(rutina, this.conf, minRep, maxRep, em, dia));
				}

				
				dia = 5;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MEDIANO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMHombro(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MEDIANO.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMHombro(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
				}
			}
			else if (cliente.getDiasSemana() == 4){
				dia = 1;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
				}

				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPBiceps(rutina, this.conf, minRep, maxRep, em, dia));
				}

				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPBiceps(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
				}
				dia = 2;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGDorsal(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGDorsal(rutina, this.conf, minRep, maxRep, em, dia));
				}

				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPTriceps(rutina, this.conf, minRep, maxRep, em, dia));
				}
							
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
				}

				dia = 3;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MUY_GRANDE.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMGPierna(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MUY_GRANDE.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMGPierna(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
				}
				dia = 4;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MEDIANO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMHombro(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MEDIANO.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMHombro(rutina, this.conf, minRep, maxRep, em, dia));
				}

			}
			else if (cliente.getDiasSemana() == 3){
				dia = 1;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
				}

				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPBiceps(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPBiceps(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
				}

				dia = 2;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGDorsal(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenGDorsal(rutina, this.conf, minRep, maxRep, em, dia));
				}

				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPTriceps(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenPTriceps(rutina, this.conf, minRep, maxRep, em, dia));
				}

				dia = 3;
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MUY_GRANDE.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMGPierna(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MUY_GRANDE.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMGPierna(rutina, this.conf, minRep, maxRep, em, dia));
				}

				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MEDIANO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMHombro(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk2 = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MEDIANO.valor, 1);
				numEjercicio = em.find(DatosObjetivo.class, pk2).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenMHombro(rutina, this.conf, minRep, maxRep, em, dia));
				}
				
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
				}

			} else if(cliente.getDiasSemana() <= 2) {
				for(dia = 1; dia <= cliente.getDiasSemana(); dia++) {
					pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
					numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
					for(int i = 0; i < numEjercicio; i++) {
						result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
					}

					result.add(new GenGDorsal(rutina, this.conf, minRep, maxRep, em, dia));
					result.add(new GenMHombro(rutina, this.conf, minRep, maxRep, em, dia));
					result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
					result.add(new GenMGPierna(rutina, this.conf, minRep, maxRep, em, dia));
					result.add(new GenPBiceps(rutina, this.conf, minRep, maxRep, em, dia));
					result.add(new GenPTriceps(rutina, this.conf, minRep, maxRep, em, dia));
				}
			}
			
			/*if(cliente.getDiasSemana() >= 3) {
				for(dia = 1; dia <= cliente.getDiasSemana(); dia++) {
					if(dia % 2 == 1) {
						pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
						numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
						for(int i = 0; i < numEjercicio; i++) {
							result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
						}
					}
				}
			} else {
				for(dia = 1; dia <= cliente.getDiasSemana(); dia++) {
					pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
					numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
					for(int i = 0; i < numEjercicio; i++) {
						result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
					}
				}
			}*/
		}
		else if (rutina.getTipoRutina() == TipoRutina.tipoCircuito){
			if(objetivo.getNombre().equals("Tonificación")){
				minRep = 12; maxRep = 15;
			} else if(objetivo.getNombre().equals("Mantenimiento")) {
				minRep = 8; maxRep = 12;
			}
			else if (objetivo.getNombre().equals("Pérdida de Peso")) {
				minRep = 6; maxRep = 12;
			}
			if(cliente.getDiasSemana() >= 2) {
				
				while(dia <= cliente.getDiasSemana()) {
					if(dia % 2 == 1) {
						//Tren superior
						pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 0);
						numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
						for(int i = 0; i < numEjercicio; i++) {
							result.add(new GenGDorsal(rutina, this.conf, minRep, maxRep, em, dia));
						}
						
						pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 0);
						numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
						for(int i = 0; i < numEjercicio; i++) {
							result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
						}
						
						pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 0);
						numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
						for(int i = 0; i < numEjercicio; i++) {
							result.add(new GenPBiceps(rutina, this.conf, minRep, maxRep, em, dia));
						}
						
						pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 0);
						numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
						for(int i = 0; i < numEjercicio; i++) {
							result.add(new GenPTriceps(rutina, this.conf, minRep, maxRep, em, dia));
						}
						
						pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MEDIANO.valor, 0);
						numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
						for(int i = 0; i < numEjercicio; i++) {
							result.add(new GenMHombro(rutina, this.conf, minRep, maxRep, em, dia));
						}
					} else {
						//Tren inferior
						pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MUY_GRANDE.valor, 0);
						numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
						for(int i = 0; i < numEjercicio; i++) {
							result.add(new GenMGPierna(rutina, this.conf, minRep, maxRep, em, dia));
						}
						pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
						numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
						for(int i = 0; i < numEjercicio; i++) {
							result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
						}
					}
					dia++;
				}
			} else {
				pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 0);
				numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
				for(int i = 0; i < numEjercicio; i++) {
					result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
				}
				result.add(new GenGDorsal(rutina, this.conf, minRep, maxRep, em, dia));
				result.add(new GenMHombro(rutina, this.conf, minRep, maxRep, em, dia));
				result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
				result.add(new GenMGPierna(rutina, this.conf, minRep, maxRep, em, dia));
				result.add(new GenPBiceps(rutina, this.conf, minRep, maxRep, em, dia));
				result.add(new GenPTriceps(rutina, this.conf, minRep, maxRep, em, dia));
			}
			if(!objetivo.getNombre().equals("Pérdida de Peso")) {
				if(cliente.getDiasSemana() >= 2) {
					
					while(dia <= cliente.getDiasSemana()) {
						if(dia % 2 == 1) {
							//Tren superior
							pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 1);
							numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
							for(int i = 0; i < numEjercicio; i++) {
								result.add(new GenGDorsal(rutina, this.conf, minRep, maxRep, em, dia));
							}
							
							pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.GRANDE.valor, 1);
							numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
							for(int i = 0; i < numEjercicio; i++) {
								result.add(new GenGPectoral(rutina, this.conf, minRep, maxRep, em, dia));
							}
							
							pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 1);
							numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
							for(int i = 0; i < numEjercicio; i++) {
								result.add(new GenPBiceps(rutina, this.conf, minRep, maxRep, em, dia));
							}
							
							pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.PEQUEÑO.valor, 1);
							numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
							for(int i = 0; i < numEjercicio; i++) {
								result.add(new GenPTriceps(rutina, this.conf, minRep, maxRep, em, dia));
							}
							
							pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MEDIANO.valor, 1);
							numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
							for(int i = 0; i < numEjercicio; i++) {
								result.add(new GenMHombro(rutina, this.conf, minRep, maxRep, em, dia));
							}
						} else {
							//Tren inferior
							pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.MUY_GRANDE.valor, 1);
							numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
							for(int i = 0; i < numEjercicio; i++) {
								result.add(new GenMGPierna(rutina, this.conf, minRep, maxRep, em, dia));
							}
							pk = new DatosObjetivoPK(this.rutina.getObjetivo().getIdObjetivos(), TamanoGMuscular.NEUTRO.valor, 1);
							numEjercicio = em.find(DatosObjetivo.class, pk).getNumeroEjercicios();
							for(int i = 0; i < numEjercicio; i++) {
								result.add(new GenAbd(rutina, this.conf, minRep, maxRep, em, dia));
							}
						}
						dia++;
					}
				} //No hay de abd de tecnica.
				
			}
		}
		return result;
	}
 
	public void run(){
		try {
			List<EjercicioGene> aEliminar = planificarMusculoDia();
			List<EjercicioGene> results = new ArrayList<EjercicioGene>();
			for(int i = 0; i < aEliminar.size(); i++) {
				if(!afectaLesiones(aEliminar.get(i))) {
					results.add(aEliminar.get(i));
				}
			}
			
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

	private boolean afectaLesiones(EjercicioGene gen) {
		boolean afecta = false;
		List<ClientesHasLesion> lesionesCliente = this.cliente.getClientesHasLesiones();
		//Method metodo;
		try {
			
			//metodo = gen.getClass().getMethod("meAfectaLesion", ClientesHasLesion.class);
			for(ClientesHasLesion lesionCliente : lesionesCliente) {
				afecta = afecta || gen.meAfectaLesion(lesionCliente);
				/*try {
					afecta = afecta || (Boolean)metodo.invoke(gen, lesionCliente);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		} /*catch (NoSuchMethodException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		finally {
			
		}
		return afecta;
	}
}

