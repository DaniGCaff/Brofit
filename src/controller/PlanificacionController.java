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
		// TODO: Si es hipert. para 5 d�as, en un d�a se hace 1 m�sculo grande o peque�o o 2 especificos (biceps+triceps).
		// TODO: Si es hipert. para 4 d�as, en un d�a se pueden hacerse <= 2 musculos (1 grande, 1 grande + 1 peque�o, B+T, NO SE PERMITE P+H).
		// TODO: Si es hipert. para 3 d�as, en un d�a se hacen 2 m�sculos (1 grande + 1 peque�o, B+T, NO SE PERMITE P+H).
	
		// TODO: Si es tonif. para rutina de t.circuito para 5 d�as:
		//		 - Primer d�a: tren superior
	    //		 - Segundo d�a: tren inferior
		//		 - tercer d�a: tren superior
		// 	     - cuarto d�a: tren inferior
		// 		 - quinto d�a: tren superior
		// TODO: No se puede hacer un circuito de tonificacion de menos de 5 d�as?
		
		// TODO: Si es tonif para rutina de t.gmuscular para X d�as:
		//	     - Mismo orden que para hipert. segun los d�as
		// TODO: No se puede hacer tonif en 2 d�as o menos?
		
		// TODO: Si es mtto. se siguen las reglas de tonificaci�n para t.circuito.
		// TODO: Si es perdida de peso, se siguen las reglas de hipertrofia.
		
		// quiero ver como cojones vamos a dise�ar estas reglas.... estructuras de datos o lo que haga falta
		// y aqui.... no pdemos discutir
		// 
		
	}
}
