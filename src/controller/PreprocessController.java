package controller;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import model.Cliente;
import model.ClientesHasLesion;
import model.Gmuscular;
import model.Lesion;
import model.Lesion.TipoLesion;
import model.Rutina;
import model.Rutina.TipoRutina;
import model.TrenCorporal;

class PreprocessController extends Controller {
	private Cliente cliente;
	private Rutina rutina;
	
	public PreprocessController(Rutina rutina, Cliente cliente,EntityManager em ) {
		
		super(em);	
		this.cliente = cliente;
		this.rutina = rutina;
	}
	
	public Cliente getCliente(){
	return cliente;
	}
	
	public void setCliente(Cliente cliente){
		this.cliente=cliente;
	}
	
	private void procesarLesiones() {
		List<ClientesHasLesion> lesiones=cliente.getClientesHasLesiones();
		for(ClientesHasLesion lesionCliente : lesiones) {
			//Lesion leve
			em.refresh(lesionCliente);
			Lesion lesion = (Lesion)em.find(Lesion.class, lesionCliente.getLesione().getIdLesiones());
			if (lesionCliente.getGravedadLesion()==TipoLesion.LEVE.ordinal()){
				em.merge(lesion);
				List<Gmuscular> gmuscular = lesion.getGmusculares();
				for (Gmuscular gm : gmuscular) {
					//Superior
					if(gm.getTipoTren()==TrenCorporal.SUPERIOR.valor){
						cliente.setCoRegresionS(0.75f);
						break;
					}
					//Inferior
					else if(gm.getTipoTren()==TrenCorporal.INFERIOR.valor){
						cliente.setCoRegresionI(0.75f);
						break;
					}
				}	
			}
			//Lesion grave
			else{
				List<Gmuscular> gmuscular = lesion.getGmusculares();
				for(Gmuscular gm : gmuscular) {
					if(gm.getTipoTren()==TrenCorporal.SUPERIOR.valor){
						cliente.setCoRegresionS(0.00f);
						break;
					}
					//Inferior
					else if(gm.getTipoTren()==TrenCorporal.INFERIOR.valor){
						cliente.setCoRegresionI(0.00f);
						break;
					}
				}
			}
		}
	}
	
	private int determinarTipoTabla(){
		int result = cliente.getMotivacion();
		if (cliente.getMotivacion() == -1){
			Random random = new Random();
			result = random.nextInt() % 2;
		}
		return result;
	}

	public void run(){
		procesarLesiones();
		if (determinarTipoTabla() == 0)
			rutina.setTipoRutina(TipoRutina.tipoCircuito);
		else rutina.setTipoRutina(TipoRutina.tipoGrupoMuscular);
	}
}
