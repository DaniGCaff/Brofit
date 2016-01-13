package genes;

import java.util.List;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;

import model.Rutina;
import model.TrenCorporal;

public class GenTI extends EjercicioGene {

	private static final long serialVersionUID = 1L;

	public GenTI(Rutina rutina, Configuration a_config, int a_lowerBounds, int a_upperBounds, EntityManager em) throws InvalidConfigurationException {
		super(rutina, a_config, a_lowerBounds, a_upperBounds, em);
	}
	
	protected Gene newGeneInternal() {
	    try {
	      return new GenTI(rutina, getConfiguration(), minRepeticiones, maxRepeticiones, em);
	    }
	    catch (InvalidConfigurationException iex) {
	      throw new IllegalStateException(iex.getMessage());
	    }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void poblarAlelos() {
		this.addAlleles((List<Integer>)em.createNamedQuery("Ejercicio.findByTrenG").setParameter("tren", TrenCorporal.SUPERIOR.valor).getResultList());
	}

}
