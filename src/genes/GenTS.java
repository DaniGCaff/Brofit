package genes;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;

import model.TrenCorporal;

public class GenTS extends EjercicioGene {

	private static final long serialVersionUID = 1L;

	public GenTS(Configuration a_config, int a_lowerBounds, int a_upperBounds, EntityManager em) throws InvalidConfigurationException {
		super(a_config, a_lowerBounds, a_upperBounds, em);
	}

	@Override
	protected void poblarAlelos() {
		this.addAlleles(em.createNamedQuery("Ejercicio.findByTren").setParameter("tren", TrenCorporal.INFERIOR.valor).getResultList());
	}
	
}
