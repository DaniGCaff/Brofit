package controller;

import javax.persistence.EntityManager;

import algorithm.BroFitnessParams;
import model.Cliente;
import model.Estres;
import model.Rutina;

public class AerobicoController extends Controller {

	private BroFitnessParams params;
	private Rutina rutina;
	private static int FCM = 220;
	
	public AerobicoController(BroFitnessParams params, Rutina rutina, EntityManager em) {
		super(em);
		this.rutina = rutina;
		this.params = params;
	}
	
	public void run() {
		int frecuenciaCliente = rutina.getCliente().getFr();
		int categoriaIMC = Estres.calcularIMC(rutina.getCliente().getPeso(), rutina.getCliente().getAltura());
		int[] pulsacionesTiempo = Estres.getPorcentajePulTiempo(categoriaIMC, (int)rutina.getCliente().getAerobica());
		params.setMinutosAerobica(pulsacionesTiempo[1]);
		int frecuenciaCardiacaFinal = ((FCM - frecuenciaCliente) * pulsacionesTiempo[0] / 100) + frecuenciaCliente;
		params.setFrecuenciaCardiacaFinal(frecuenciaCardiacaFinal);
		float estresAerobico = Estres.getEstresAerobico(categoriaIMC, (int)rutina.getCliente().getAerobica());
		params.setEstresAerobico(estresAerobico);
	}

}
