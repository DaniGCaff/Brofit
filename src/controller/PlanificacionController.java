package controller;

import model.Cliente;
import model.Objetivo;
import model.Rutina;

public class PlanificacionController {
	Cliente cliente;
	Rutina rutina;
	Objetivo objetivo;
	public PlanificacionController(Cliente cliente, Rutina rutina){
		this.cliente = cliente;
		this.rutina = rutina;
		this.objetivo = rutina.getObjetivo();
	}
	
/*	CONCLUSION: SE COMPRUEBA UNA VEZ SE TENGA LA SALIDA; 
 * SI NO NO SE PODRIA VER LO DE 1 MUSCULO O MAS POR DIA ETC
 * private void planificarMusculoDia(){
		
		if (objetivo.getNombre().equals("hipertrofia")){
			if (cliente.getDiasSemana() == 5 && ejercicios !=triceps y biceps){
			rutina.setMusculosDia(1);
			
			}
		}
	}*/
	public void run(){
		// TODO: Si es hipert. para 5 días, en un día se hace 1 músculo grande o pequeño o 2 especificos (biceps+triceps).
		// TODO: Si es hipert. para 4 días, en un día se pueden hacerse <= 2 musculos (1 grande, 1 grande + 1 pequeño, B+T, NO SE PERMITE P+H).
		// TODO: Si es hipert. para 3 días, en un día se hacen 2 músculos (1 grande + 1 pequeño, B+T, NO SE PERMITE P+H).
	
		// TODO: Si es tonif. para rutina de t.circuito para 5 días:
		//		 - Primer día: tren superior
	    //		 - Segundo día: tren inferior
		//		 - tercer día: tren superior
		// 	     - cuarto día: tren inferior
		// 		 - quinto día: tren superior
		// TODO: No se puede hacer un circuito de tonificacion de menos de 5 días?
		
		// TODO: Si es tonif para rutina de t.gmuscular para X días:
		//	     - Mismo orden que para hipert. segun los días
		// TODO: No se puede hacer tonif en 2 días o menos?
		
		// TODO: Si es mtto. se siguen las reglas de tonificación para t.circuito.
		// TODO: Si es perdida de peso, se siguen las reglas de hipertrofia.
		
		// quiero ver como cojones vamos a diseñar estas reglas.... estructuras de datos o lo que haga falta
		// y aqui.... no pdemos discutir
		// 
		
	}
}
