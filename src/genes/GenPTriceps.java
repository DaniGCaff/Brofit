package genes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;

import model.ClientesHasLesion;
import model.Ejercicio;
import model.Gmuscular;
import model.Lesion.TipoLesion;
import model.Rutina;
import model.TrenCorporal;

public class GenPTriceps extends EjercicioGene {

	private static final long serialVersionUID = 1L;

	public GenPTriceps(Rutina rutina, Configuration a_config, int a_lowerBounds, int a_upperBounds, EntityManager em, int diaRutina) throws InvalidConfigurationException {
		super(rutina, a_config, a_lowerBounds, a_upperBounds, em, diaRutina);
	}

	protected Gene newGeneInternal() {
	    try {
	      return new GenPTriceps(rutina, getConfiguration(), minRepeticiones, maxRepeticiones, em, diaRutina);
	    }
	    catch (InvalidConfigurationException iex) {
	      throw new IllegalStateException(iex.getMessage());
	    }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void poblarAlelos() {
		this.addAlleles((List<Integer>)em.createNamedQuery("Ejercicio.findByGMuscularG").setParameter("gmuscular", "Triceps").getResultList());
	}

	public boolean meAfectaLesion(ClientesHasLesion lesionCliente) {
		List<Gmuscular> gmusculares = lesionCliente.getLesione().getGmusculares();
		// Si es una lesion grave, y est� ubicada en mi tren corporal, es decir el superior... me afecta.
		if(lesionCliente.getGravedadLesion() == TipoLesion.GRAVE.ordinal()) {
			for(Gmuscular gmuscular : gmusculares) {
				if(gmuscular.getTipoTren() == TrenCorporal.SUPERIOR.valor) {
					return true;
				}
			}
		} else {
			   for(Gmuscular gmuscular : lesionCliente.getLesione().getGmusculares()) {
				   if(gmuscular.getNombre().equals("Triceps")) {
				    List<Ejercicio> ejercicios = lesionCliente.getEjerciciosNoRehabilitadores();
				       List<Integer>idEjercicios = new ArrayList<Integer>();
				       for (Ejercicio ej: ejercicios){
				     if(ej.getGmuscular().getNombre().equals("Triceps"))
				          idEjercicios.add(ej.getIdEjercicios());
				       }
				       this.removeAlleles(alelosInternos);
				       this.addAlleles(idEjercicios);
				   }
				     }  
				  }
		return false;
	}
}
