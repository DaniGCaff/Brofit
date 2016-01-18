package genes;

import java.util.List;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;

import model.Rutina;
import model.TamanoGMuscular;

public class GenGHombro extends EjercicioGene {

	private static final long serialVersionUID = 1L;

	public GenGHombro(Rutina rutina, Configuration a_config, int a_lowerBounds, int a_upperBounds, EntityManager em, int diaRutina) throws InvalidConfigurationException {
		super(rutina, a_config, a_lowerBounds, a_upperBounds, em, diaRutina);
	}
	
	protected Gene newGeneInternal() {
	    try {
	      return new GenGHombro(rutina, getConfiguration(), minRepeticiones, maxRepeticiones, em, diaRutina);
	    }
	    catch (InvalidConfigurationException iex) {
	      throw new IllegalStateException(iex.getMessage());
	    }
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void poblarAlelos() {
		this.addAlleles((List<Integer>)em.createNamedQuery("Ejercicio.findByGMuscularG").setParameter("gmuscular", "Hombro").getResultList());
	}
}
