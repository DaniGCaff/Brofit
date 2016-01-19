package genes;

import java.util.List;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;

import model.ClientesHasLesion;
import model.Ejercicio;
import model.Gmuscular;
import model.Rutina;
import model.TamanoGMuscular;
import model.TrenCorporal;
import model.Lesion.TipoLesion;

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
			List<Ejercicio> ejercicios = lesionCliente.getEjerciciosNoRehabilitadores();
			for(Ejercicio ejercicio : ejercicios)
				this.removeAlleles(ejercicio.getIdEjercicios());
			
			if(super.numAlelos <= 0) {
				for(Gmuscular gmuscular : gmusculares) {
					if(gmuscular.getNombre().equals("Triceps"))
						return true;
				}
			}
		}
		return false;
	}
}
