package genes;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;

public class GenH extends EjercicioGene {

	private static final long serialVersionUID = 1L;

	public GenH(Configuration a_config, int a_lowerBounds, int a_upperBounds, EntityManager em) throws InvalidConfigurationException {
		super(a_config, a_lowerBounds, a_upperBounds, em);
	}
	
	@Override
	protected void poblarAlelos() {
		this.addAlleles(em.createNamedQuery("Ejercicio.getByGMuscular").setParameter("gmuscular", "Hombros").getResultList());
	}

}
