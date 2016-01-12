package genes;

import java.util.List;

import javax.persistence.EntityManager;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;

import model.Rutina;

public class GenBT extends EjercicioGene {

	private static final long serialVersionUID = 1L;

	public GenBT(Rutina rutina, Configuration a_config, int a_lowerBounds, int a_upperBounds, EntityManager em) throws InvalidConfigurationException {
		super(rutina, a_config, a_lowerBounds, a_upperBounds, em);
	}
	
	@Override
	protected void poblarAlelos() {
		this.addAlleles((List<Integer>)em.createNamedQuery("Ejercicio.findByGMuscularG").setParameter("gmuscular", "Biceps").getResultList());
		this.addAlleles((List<Integer>)em.createNamedQuery("Ejercicio.findByGMuscularG").setParameter("gmuscular", "Triceps").getResultList());
	}

}
